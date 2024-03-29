package com.real.realoasis.domain.auth.presentation.data.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@RequiredArgsConstructor
@Getter
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime expiredAt;
    private final String coupleCode;
    private final Boolean isCouple;
}
