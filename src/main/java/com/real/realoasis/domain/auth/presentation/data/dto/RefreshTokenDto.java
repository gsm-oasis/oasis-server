package com.real.realoasis.domain.auth.presentation.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
public class RefreshTokenDto {
    private final String accessToken;
    private final String refreshToken;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private final LocalDateTime accessExp;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private final LocalDateTime refreshExp;
}
