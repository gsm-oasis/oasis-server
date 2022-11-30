package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
