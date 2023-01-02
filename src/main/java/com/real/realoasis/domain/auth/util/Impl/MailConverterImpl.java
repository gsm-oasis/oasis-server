package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.data.dto.MailDto;
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
}
