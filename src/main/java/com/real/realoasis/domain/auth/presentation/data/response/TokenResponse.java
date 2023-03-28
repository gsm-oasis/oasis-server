package com.real.realoasis.domain.auth.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Long expiredAt;
    private final String code;
    private final boolean couple;
}
