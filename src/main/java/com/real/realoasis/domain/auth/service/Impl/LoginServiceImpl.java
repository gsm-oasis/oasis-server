package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.dto.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.LoginResponse;
import com.real.realoasis.domain.auth.service.LoginService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userFacade.findUserById(loginRequest.getId());
        userFacade.checkPassword(user, loginRequest.getPassword());

        String accessToken = jwtTokenProvider.generateAccessToken(loginRequest.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(loginRequest.getId());

        user.updateRefreshToken(refreshToken);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .code(user.getCode())
                .couple(user.isCouple())
                .build();
    }
}
