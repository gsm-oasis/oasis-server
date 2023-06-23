package com.real.realoasis.domain.user.presentation.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeRequest {
    private String originalPassword;
    private String password;
}
