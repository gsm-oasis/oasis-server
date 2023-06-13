package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.data.response.SignupResponse;
import com.real.realoasis.domain.auth.presentation.data.response.TokenResponse;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuthConverterImpl implements AuthConverter {
    private final PasswordEncoder passwordEncoder;
    @Override
    public SignupDto toDto(SignUpRequest signupRequest) {
        return SignupDto.builder()
                .id(signupRequest.getId())
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
                .nickname(signupRequest.getNickname())
                .build();
    }

    @Override
    public User toEntity(SignupDto signupDto, String code) {
        String password = passwordEncoder.encode(signupDto.getPassword());
        return User.builder()
                .id(signupDto.getId())
                .email(signupDto.getEmail())
                .password(password)
                .nickname(signupDto.getNickname())
                .coupleCode(code)
                .build();
    }

    @Override
    public SignupResponse toResponse(CoupleCodeDto authCodeDto) {
        return SignupResponse.builder()
                .coupleCode(authCodeDto.getCoupleCode())
                .build();
    }

    @Override
    public LoginDto toDto(LoginRequest loginRequest) {
        return LoginDto.builder()
                .id(loginRequest.getId())
                .password(loginRequest.getPassword())
                .build();
    }

    @Override
    public TokenDto toDto(String accessToken, String refreshToken, LocalDateTime accessExp, LocalDateTime refreshExp, User user) {
        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessExp(accessExp)
                .refreshExp(refreshExp)
                .coupleCode(user.getCoupleCode())
                .isCouple(user.isCouple())
                .build();
    }

    @Override
    public TokenResponse toResponse(TokenDto tokenDto) {
        return TokenResponse.builder()
                .accessToken(tokenDto.getAccessToken())
                .refreshToken(tokenDto.getRefreshToken())
                .accessExp(tokenDto.getAccessExp())
                .coupleCode(tokenDto.getCoupleCode())
                .isCouple(tokenDto.isCouple())
                .build();
    }

    @Override
    public SearchPwDto toDto(SearchPwRequest searchPWRequest) {
        return SearchPwDto.builder()
                .email(searchPWRequest.getEmail())
                .newPassword(searchPWRequest.getNewPassword())
                .checkPassword(searchPWRequest.getCheckPassword())
                .build();
    }

    @Override
    public CoupleCodeDto toDto(String code) {
        return CoupleCodeDto.builder()
                .coupleCode(code)
                .build();
    }

    @Override
    public RefreshToken toEntity(String id, String refreshToken) {
        return RefreshToken.builder()
                .userId(id)
                .token(refreshToken)
                .build();
    }
}
