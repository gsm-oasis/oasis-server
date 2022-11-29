package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;

public interface SignUpService {
    void signUp(SignUpRequest signupRequest);
}
