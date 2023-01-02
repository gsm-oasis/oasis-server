package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SignupResponse;

public interface SignUpService {
    SignupResponse signUp(SignUpRequest signupRequest);
}
