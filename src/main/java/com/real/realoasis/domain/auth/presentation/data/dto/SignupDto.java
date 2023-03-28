package com.real.realoasis.domain.auth.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class SignupDto {
    private final String id;
    private final String email;
    private final String password;
    private final String nickname;
}
