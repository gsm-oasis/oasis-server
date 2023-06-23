package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.real.realoasis.domain.auth.presentation.data.dto.TokenDto;

public interface ReissueService {
    RefreshTokenDto reissue(String refreshToken);
}
