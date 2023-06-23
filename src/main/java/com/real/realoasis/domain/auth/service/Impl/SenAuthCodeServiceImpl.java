package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import com.real.realoasis.domain.auth.domain.repository.AuthCodeRepository;
import com.real.realoasis.domain.auth.presentation.data.dto.CreateMessageDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SendEmailDto;
import com.real.realoasis.domain.auth.service.SendAuthCodeService;
import com.real.realoasis.domain.auth.util.MailConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SenAuthCodeServiceImpl implements SendAuthCodeService {
    private final MailConverter mailConverter;
    private final AuthCodeRepository authCodeRepository;
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    @Override
    public SendEmailDto send(String email) throws MessagingException, UnsupportedEncodingException {
        //메일전송에 필요한 정보 설정
        CreateMessageDto createMessageDto = createEmailForm(email);
        //실제 메일 전송
        emailSender.send(createMessageDto.getMessage());

        AuthCode authCode = mailConverter.toEntity(email, createMessageDto.getAuthCode());
        authCodeRepository.save(authCode);

        return mailConverter.toEmailDto(email);

    }

    // 메일 양식 작성
    private CreateMessageDto createEmailForm(String email) throws MessagingException{
        String authCode = createCode(); //인증 코드 생성
        String setFrom = "shgurtns7236@naver.com"; //email-config 에 설정한 자신의 이메일 주소(보내는 사람)
        String title = "OASIS 인증 번호"; //제목

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, email); //보낼 이메일 설정
        message.setSubject(title); //제목 설정
        message.setFrom(setFrom); //보내는 이메일
        message.setText(setContext(authCode), "utf-8", "html");

        return mailConverter.toDto(message, authCode);
    }

    private static String createCode() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 4; i++) {
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    //타임리프를 이용한 context 설정
    private String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context); //mail.html
    }
}
