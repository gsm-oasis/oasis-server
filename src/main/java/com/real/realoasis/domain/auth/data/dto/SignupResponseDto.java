package com.real.realoasis.domain.auth.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class SignupResponseDto {
    private final String code;
}
