package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.service.SearchIdService;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class SearchIdServiceImpl implements SearchIdService {
    private final JavaMailSender emailSender;
    private final UserFacade userFacade;
    private final SpringTemplateEngine templateEngine;

    @Override
    public void send(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException {
        //메일전송에 필요한 정보 설정
        MimeMessage emailForm = createSearchIdForm(searchIdDto.getEmail());
        //실제 메일 전송
        emailSender.send(emailForm);
    }

    private MimeMessage createSearchIdForm(String email) throws MessagingException{
        String setFrom = "shgurtns7236@naver.com";
        String title = "OASIS 아이디 찾기";

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject(title);
        message.setFrom(setFrom);
        message.setText(setContext(userFacade.findUserIdByEmail(email)), "utf-8", "html");

        return message;
    }

    //타임리프를 이용한 context 설정
    private String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context); //mail.html
    }
}
