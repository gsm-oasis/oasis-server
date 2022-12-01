package com.real.realoasis.domain.auth.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void createCode();
    MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException;

    MimeMessage createSearchIdForm(String email) throws MessagingException, UnsupportedEncodingException;
    void sendId(String toEmail) throws MessagingException, UnsupportedEncodingException;

    void sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException;

    void confirmAuthenticationCode(String authenticationCode);
}
