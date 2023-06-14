package com.real.realoasis.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class PasswordChangeDto {
    private final String originalPassword;
    private final String password;
}
