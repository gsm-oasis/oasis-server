package com.real.realoasis.domain.auth.presentation.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@RequiredArgsConstructor
@Getter
public class TokenDto {
    private final String accessToken;
    private final String refreshToken;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private final LocalDateTime expiredAt;
    private final String coupleCode;
    private final Boolean isCouple;
}
