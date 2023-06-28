package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.domain.repository.RefreshTokenRepository;
import com.real.realoasis.domain.auth.exception.ExpiredTokenException;
import com.real.realoasis.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.real.realoasis.domain.auth.service.ReissueService;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReissueServiceImpl implements ReissueService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthConverter authConverter;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RefreshTokenDto reissue(String refreshToken) {
        if(jwtTokenProvider.validateToken(refreshToken, JwtTokenProvider.TokenType.REFRESH_TOKEN)){
            throw new ExpiredTokenException(ErrorCode.EXPIRATION_TOKEN_EXCEPTION);
        }

        User user = userFacade.findUserById(jwtTokenProvider.getTokenSubject(refreshToken, JwtTokenProvider.TokenType.REFRESH_TOKEN));
        RefreshToken existingRefreshToken = refreshTokenRepository.findByToken(refreshToken);
        RefreshTokenDto refreshTokenDto = makeTokenDto(user);

        refreshTokenRepository.save(authConverter.toEntity(existingRefreshToken.getUserId(), refreshTokenDto.getRefreshToken()));

        return refreshTokenDto;
    }

    private RefreshTokenDto makeTokenDto(User user){
        String accessToken = jwtTokenProvider.generateAccessToken(user.getUserId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getUserId());
        LocalDateTime expiredAt = jwtTokenProvider.getAccessTokenExpiredTime();

        return new RefreshTokenDto(
                accessToken,
                refreshToken,
                expiredAt
        );
    }
}
