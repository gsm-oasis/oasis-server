package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.SendEmailDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface SendAuthCodeService {
    SendEmailDto send(String email) throws MessagingException, UnsupportedEncodingException;
}
