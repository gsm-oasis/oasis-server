package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.SignupResponse;

public interface SignUpService {
    SignupResponse signUp(SignUpRequest signupRequest);
}
