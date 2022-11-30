package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.response.ReissueTokenResponse;

public interface ReissueTokenService {
    ReissueTokenResponse reissue(String refreshToken);
}
