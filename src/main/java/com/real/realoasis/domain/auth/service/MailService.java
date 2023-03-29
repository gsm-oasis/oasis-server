package com.real.realoasis.domain.auth.service;


import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SendAuthCodeDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailService {
    void sendId(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException;

    SendAuthCodeDto sendEmail(String email) throws MessagingException, UnsupportedEncodingException;

    void confirmAuthenticationCode(String code, String sentCode);
}
