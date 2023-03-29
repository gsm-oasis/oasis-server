package com.real.realoasis.domain.auth.service;


import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailService {
    void sendId(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException;

    void sendEmail(String email) throws MessagingException, UnsupportedEncodingException;

    void confirmAuthenticationCode(CoupleCodeDto authCodeDto);
}
