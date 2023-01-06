package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.data.dto.LoginDto;
import com.real.realoasis.domain.auth.data.dto.SearchPwDto;
import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.dto.TokenDto;
import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.request.SearchPWRequest;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthConverterImpl implements AuthConverter {
    private final PasswordEncoder passwordEncoder;
    @Override
    public SignupDto toSignupDto(SignUpRequest signupRequest) {
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
    public SignupResponse toSignResponse(String code) {
        return SignupResponse.builder()
                .code(code)
                .build();
    }

    @Override
    public LoginDto toLoginDto(LoginRequest loginRequest) {
        return LoginDto.builder()
                .id(loginRequest.getId())
                .password(loginRequest.getPassword())
                .build();
    }

    @Override
    public TokenDto toTokenDto(String accessToken, String refreshToken, Long expiredAt, User user) {
        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .code(user.getCode())
                .couple(user.isCouple())
                .build();
    }

    @Override
    public TokenResponse toTokenResponse(TokenDto tokenDto) {
        return TokenResponse.builder()
                .accessToken(tokenDto.getAccessToken())
                .refreshToken(tokenDto.getRefreshToken())
                .expiredAt(tokenDto.getExpiredAt())
                .code(tokenDto.getCode())
                .couple(tokenDto.isCouple())
                .build();
    }

    @Override
    public SearchPwDto toSearchPwDto(SearchPWRequest searchPWRequest) {
        return SearchPwDto.builder()
                .id(searchPWRequest.getId())
                .build();
    }

    @Override
    public SearchPWResponse toSearchPwResponse(String pw) {
        return SearchPWResponse.builder()
                .password(pw)
                .build();
    }
}
