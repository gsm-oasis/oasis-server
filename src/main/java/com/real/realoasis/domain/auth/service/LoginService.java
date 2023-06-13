package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.LoginDto;
import com.real.realoasis.domain.auth.presentation.data.dto.TokenDto;

public interface LoginService {
    TokenDto login(LoginDto loginDto);
}
