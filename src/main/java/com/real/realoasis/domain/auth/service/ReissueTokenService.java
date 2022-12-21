package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.response.LoginResponse;

public interface ReissueTokenService {
    LoginResponse reissue(String refreshToken);
}
