package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchIdRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SendMailRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SendAuthCodeResponse;
import com.real.realoasis.domain.auth.util.MailConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class MailConverterImpl implements MailConverter {

    @Override
    public MailDto toDto(SendMailRequest sendMailRequest) {
        return MailDto.builder()
                .email(sendMailRequest.getEmail())
                .build();
    }

    @Override
    public CoupleCodeDto toDto(AuthenticationCodeRequest authenticationCodeRequest) {
        return CoupleCodeDto.builder()
                .coupleCode(authenticationCodeRequest.getCode())
                .build();
    }

    @Override
    public SearchIdDto toDto(SearchIdRequest searchIDRequest) {
        return SearchIdDto.builder()
                .email(searchIDRequest.getEmail())
                .build();
    }

    @Override
    public CreateMessageDto toDto(MimeMessage message, String authCode) {
        return CreateMessageDto.builder()
                .message(message)
                .authCode(authCode)
                .build();
    }

    @Override
    public AuthCode toEntity(String email, String authCode) {
        return AuthCode.builder()
                .email(email)
                .code(authCode)
                .build();
    }

    @Override
    public SendAuthCodeResponse toResponse(SendAuthCodeDto sendAuthCodeDto) {
        return SendAuthCodeResponse.builder()
                .sentCode(sendAuthCodeDto.getSentCode())
                .build();
    }

    @Override
    public SendAuthCodeDto toDto(String code) {
        return SendAuthCodeDto.builder()
                .sentCode(code)
                .build();
    }

    @Override
    public SendEmailDto toEmailDto(String email) {
        return SendEmailDto.builder()
                .email(email)
                .build();
    }
}
