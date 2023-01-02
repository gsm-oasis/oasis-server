package com.real.realoasis.domain.auth.util.Impl;

import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
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
}
