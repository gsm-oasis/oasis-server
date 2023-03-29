package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SearchPwResponse;
import com.real.realoasis.domain.auth.presentation.data.response.SignupResponse;
import com.real.realoasis.domain.auth.presentation.data.response.TokenResponse;
import com.real.realoasis.domain.user.data.entity.User;

public interface AuthConverter {
    SignupDto toDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto, String code);

    SignupResponse toResponse(AuthCodeDto authCodeDto);

    LoginDto toDto(LoginRequest loginRequest);

    TokenDto toDto(String accessToken, String refreshToken, Long expireAt, User user);

    TokenResponse toResponse(TokenDto tokenDto);

    SearchPwDto toDto(SearchPwRequest searchPWRequest);

    AuthCodeDto toDto(String code);
}
