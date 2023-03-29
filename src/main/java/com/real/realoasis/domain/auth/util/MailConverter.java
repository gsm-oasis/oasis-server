package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchIdRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SendMailRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SendAuthCodeResponse;

import javax.mail.internet.MimeMessage;

public interface MailConverter {
    MailDto toDto(SendMailRequest sendMailRequest);
    CoupleCodeDto toDto(AuthenticationCodeRequest authenticationCodeRequest);
    SearchIdDto toDto(SearchIdRequest searchIDRequest);
    CreateMessageDto toDto(MimeMessage message, String authCode);
    AuthCode toEntity(String email, String authCode);
    SendAuthCodeResponse toResponse(SendAuthCodeDto sendAuthCodeDto);
    SendAuthCodeDto toDto(String code);
}
