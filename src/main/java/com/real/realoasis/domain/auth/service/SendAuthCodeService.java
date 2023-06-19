package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.SendAuthCodeDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface SendAuthCodeService {
    SendAuthCodeDto send(String email) throws MessagingException, UnsupportedEncodingException;
}
