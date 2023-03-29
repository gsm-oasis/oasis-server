package com.real.realoasis.domain.auth.service;


import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.MailDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void sendId(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException;

    void sendEmail(MailDto mailDto) throws MessagingException, UnsupportedEncodingException;

    void confirmAuthenticationCode(CoupleCodeDto authCodeDto);
}
