package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SignupDto;

public interface SignUpService {
    CoupleCodeDto signUp(SignupDto signupDto);
}
