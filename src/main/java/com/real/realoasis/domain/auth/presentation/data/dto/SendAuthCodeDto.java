package com.real.realoasis.domain.auth.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class SendAuthCodeDto {
    private final String sentCode;
}
