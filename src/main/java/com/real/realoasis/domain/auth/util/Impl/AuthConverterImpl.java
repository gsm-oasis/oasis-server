package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.data.dto.*;
import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SearchPwResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
    public User toEntity(SignupDto signupDto) {
        String password = passwordEncoder.encode(signupDto.getPassword());
        return User.builder()
                .id(signupDto.getId())
                .email(signupDto.getEmail())
                .password(password)
                .nickname(signupDto.getNickname())
                .build();
    }

    @Override
    public SignupResponse toResponse(AuthCodeDto authCodeDto) {
        return SignupResponse.builder()
                .code(authCodeDto.getCode())
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
    public TokenDto toDto(String accessToken, String refreshToken, Long expiredAt, User user) {
        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .code(user.getCode())
                .couple(user.isCouple())
                .build();
    }

    @Override
    public TokenResponse toResponse(TokenDto tokenDto) {
        return TokenResponse.builder()
                .accessToken(tokenDto.getAccessToken())
                .refreshToken(tokenDto.getRefreshToken())
                .expiredAt(tokenDto.getExpiredAt())
                .code(tokenDto.getCode())
                .couple(tokenDto.isCouple())
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
    public SearchPwResponse toSearchPwResponse(String pw) {
        return SearchPwResponse.builder()
                .password(pw)
                .build();
    }

    @Override
    public AuthCodeDto toDto(String code) {
        return AuthCodeDto.builder()
                .code(code)
                .build();
    }
}
