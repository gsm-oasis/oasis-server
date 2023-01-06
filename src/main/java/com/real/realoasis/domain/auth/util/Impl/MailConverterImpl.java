package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.data.dto.AuthCodeDto;
import com.real.realoasis.domain.auth.data.dto.MailDto;
import com.real.realoasis.domain.auth.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.data.request.SearchIDRequest;
import com.real.realoasis.domain.auth.data.request.SendMailRequest;
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
    public AuthCodeDto toDto(AuthenticationCodeRequest authenticationCodeRequest) {
        return AuthCodeDto.builder()
                .code(authenticationCodeRequest.getCode())
                .build();
    }

    @Override
    public SearchIdDto toSearchIdDto(SearchIDRequest searchIDRequest) {
        return SearchIdDto.builder()
                .email(searchIDRequest.getEmail())
                .build();
    }
}
