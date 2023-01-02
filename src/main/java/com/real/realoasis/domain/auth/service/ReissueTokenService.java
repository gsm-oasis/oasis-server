package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.response.LoginResponse;

public interface ReissueTokenService {
    LoginResponse reissue(String refreshToken);
}
