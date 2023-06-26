package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.domain.repository.RefreshTokenRepository;
import com.real.realoasis.domain.auth.presentation.data.dto.LoginDto;
import com.real.realoasis.domain.auth.presentation.data.dto.TokenDto;
import com.real.realoasis.domain.auth.service.LoginService;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserFacade userFacade;
    private final AuthConverter authConverter;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final CoupleRepository coupleRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TokenDto login(LoginDto loginDto) {
        User user = userFacade.findUserById(loginDto.getId());
        userFacade.checkPassword(user, loginDto.getPassword());

        TokenDto tokenDto = makeTokenDto(user);

        RefreshToken refresh = authConverter.toEntity(user.getId(), tokenDto.getRefreshToken());
        refreshTokenRepository.save(refresh);

        return tokenDto;
    }

    private TokenDto makeTokenDto(User user){
        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getId());
        LocalDateTime expiredAt = jwtTokenProvider.getAccessTokenExpiredTime();

        return authConverter.toDto(accessToken, refreshToken, expiredAt, user);
    }
}
