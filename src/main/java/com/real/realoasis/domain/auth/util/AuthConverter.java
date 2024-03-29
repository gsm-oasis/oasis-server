package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SendEmailResponse;
import com.real.realoasis.domain.auth.presentation.data.response.SignupResponse;
import com.real.realoasis.domain.auth.presentation.data.response.RefreshTokenResponse;
import com.real.realoasis.domain.auth.presentation.data.response.TokenResponse;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;

import java.time.LocalDateTime;

public interface AuthConverter {
    SignupDto toDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto, String coupleCode);

    SignupResponse toResponse(CoupleCodeDto authCodeDto);

    LoginDto toDto(LoginRequest loginRequest);

    TokenDto toDto(String accessToken, String refreshToken, LocalDateTime expiredAt, User user);

    TokenResponse toResponse(TokenDto tokenDto);
    RefreshTokenResponse toResponse(RefreshTokenDto tokenDto);

    SearchPwDto toDto(SearchPwRequest searchPWRequest);

    CoupleCodeDto toDto(String code);
    RefreshToken toEntity(String id, String refreshToken);
    SendEmailResponse toResponse(SendEmailDto sendEmailDto);
}
