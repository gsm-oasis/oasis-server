package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.exception.ExpiredTokenException;
import com.real.realoasis.domain.auth.exception.InvalidTokenException;
import com.real.realoasis.domain.auth.data.response.LoginResponse;
import com.real.realoasis.domain.auth.service.ReissueTokenService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ReissueTokenServiceImpl implements ReissueTokenService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;
    private final RedisTemplate<String, Object> redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginResponse reissue(String refreshToken) {
        if(jwtTokenProvider.validateToken(refreshToken)){
            throw new ExpiredTokenException(ErrorCode.EXPIRATION_TOKEN_EXCEPTION);
        }

        User user = userFacade.findUserById(jwtTokenProvider.getUserPk(refreshToken));

        String redisRefreshToken = (String) redisTemplate.opsForValue().get("refresh:" + user.getId());
        if(Objects.equals(redisRefreshToken, refreshToken)){
            throw new InvalidTokenException(ErrorCode.INVALID_TOKEN_EXCEPTION);
        }

        String newAccessToken = jwtTokenProvider.generateAccessToken(user.getId());
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(user.getId());

        redisTemplate.opsForValue()
                .set("RefreshToken:" + user.getId(), newRefreshToken,
                        jwtTokenProvider.getExpiredTime(newRefreshToken), TimeUnit.MILLISECONDS);


        return LoginResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .expiredAt(jwtTokenProvider.getExpiredTime(newAccessToken))
                .code(user.getCode())
                .couple(user.isCouple())
                .build();
    }
}
