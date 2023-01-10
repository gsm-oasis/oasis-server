package com.real.realoasis.domain.auth.data.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class LoginResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Long expiredAt;
    private final String code;
    private final boolean couple;
}
