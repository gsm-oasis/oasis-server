package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.CreateMessageDto;
import com.real.realoasis.domain.auth.presentation.data.dto.MailDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.presentation.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchIdRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SendMailRequest;

import javax.mail.internet.MimeMessage;

public interface MailConverter {
    MailDto toDto(SendMailRequest sendMailRequest);
    CoupleCodeDto toDto(AuthenticationCodeRequest authenticationCodeRequest);
    SearchIdDto toDto(SearchIdRequest searchIDRequest);
    CreateMessageDto toDto(MimeMessage message, String authCode);
    AuthCode toEntity(String email, String authCode);
}
