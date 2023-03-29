package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.MailDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.presentation.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchIdRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SendMailRequest;
import com.real.realoasis.domain.auth.util.MailConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
                .code(authenticationCodeRequest.getCode())
                .build();
    }

    @Override
    public SearchIdDto toDto(SearchIdRequest searchIDRequest) {
        return SearchIdDto.builder()
                .email(searchIDRequest.getEmail())
                .build();
    }
}
