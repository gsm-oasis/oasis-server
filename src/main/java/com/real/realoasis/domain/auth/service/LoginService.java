package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
