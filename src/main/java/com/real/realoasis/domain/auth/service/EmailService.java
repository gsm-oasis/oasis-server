package com.real.realoasis.domain.auth.service;


import com.real.realoasis.domain.auth.data.dto.AuthCodeDto;
import com.real.realoasis.domain.auth.data.dto.MailDto;
import com.real.realoasis.domain.auth.data.dto.SearchIdDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void createCode();
    MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException;

    MimeMessage createSearchIdForm(String email) throws MessagingException, UnsupportedEncodingException;
    void sendId(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException;

    void sendEmail(MailDto mailDto) throws MessagingException, UnsupportedEncodingException;

    void confirmAuthenticationCode(AuthCodeDto authCodeDto);
}
