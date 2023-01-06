package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.data.dto.LoginDto;
import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.dto.TokenDto;
import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;
import com.real.realoasis.domain.user.entity.User;

public interface AuthConverter {
    SignupDto toSignupDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto);

    SignupResponse toSignResponse(String code);

    LoginDto toLoginDto(LoginRequest loginRequest);

    TokenDto toTokenDto(String accessToken, String refreshToken, Long expireAt, User user);

    TokenResponse toTokenResponse(TokenDto tokenDto);
}
