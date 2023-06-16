package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SignupResponse;
import com.real.realoasis.domain.auth.presentation.data.response.TokenResponse;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;

import java.time.LocalDateTime;

public interface AuthConverter {
    SignupDto toDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto);

    SignupResponse toResponse(CoupleCodeDto authCodeDto);

    LoginDto toDto(LoginRequest loginRequest);

    TokenDto toDto(String accessToken, String refreshToken, LocalDateTime accessExp, LocalDateTime refreshExp, User user);

    TokenResponse toResponse(TokenDto tokenDto);

    SearchPwDto toDto(SearchPwRequest searchPWRequest);

    CoupleCodeDto toDto(String code);
    RefreshToken toEntity(String id, String refreshToken);
    Couple toEntity(User user, String code);
}
