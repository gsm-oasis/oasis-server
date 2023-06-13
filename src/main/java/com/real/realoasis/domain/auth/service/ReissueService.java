package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.TokenDto;

public interface ReissueService {
    TokenDto reissue(String refreshToken);
}
