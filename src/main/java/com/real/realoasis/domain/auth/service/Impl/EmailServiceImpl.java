package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.AuthCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.MailDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.exception.InValidAuthCodeException;
import com.real.realoasis.domain.auth.service.EmailService;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final UserFacade userFacade;

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    private String authNum; //랜덤 인증 코드


    // 랜덤 인증 코드 생성
    @Override
    public void createCode() {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(3);

            switch (index) {
                case 0 :
                    key.append((char) (random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) (random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        authNum = key.toString();
    }

    // 메일 양식 작성
    @Override
    public MimeMessage createEmailForm(String email) throws MessagingException{
        createCode(); //인증 코드 생성
        String setFrom = "shgurtns7236@naver.com"; //email-config 에 설정한 자신의 이메일 주소(보내는 사람)
        String title = "OASIS 인증 번호"; //제목

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, email); //보낼 이메일 설정
        message.setSubject(title); //제목 설정
        message.setFrom(setFrom); //보내는 이메일
        message.setText(setContext(authNum), "utf-8", "html");

        return message;
    }

    @Override
    public MimeMessage createSearchIdForm(String email) throws MessagingException{

        String setFrom = "shgurtns7236@naver.com";
        String title = "OASIS 아이디 찾기";

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject(title);
        message.setFrom(setFrom);
        message.setText(setContext(userFacade.findUserIdByEmail(email)), "utf-8", "html");

        return message;
    }

    @Override
    public void sendId(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException {
        //메일전송에 필요한 정보 설정
        MimeMessage emailForm = createSearchIdForm(searchIdDto.getEmail());
        //실제 메일 전송
        emailSender.send(emailForm);
    }

    // 실제 메일 전송
    @Override
    public void sendEmail(MailDto mailDto) throws MessagingException {
        //메일전송에 필요한 정보 설정
        MimeMessage emailForm = createEmailForm(mailDto.getEmail());
        //실제 메일 전송
        emailSender.send(emailForm);
    }

    // 인증코드 확인
    @Override
    public void confirmAuthenticationCode(AuthCodeDto authCodeDto) {
        if(!authCodeDto.getCode().equals(authNum)){
            throw new InValidAuthCodeException(ErrorCode.INVALID_AUTH_CODE_EXCEPTION);
        }
    }

    //타임리프를 이용한 context 설정
    public String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context); //mail.html
    }
}
