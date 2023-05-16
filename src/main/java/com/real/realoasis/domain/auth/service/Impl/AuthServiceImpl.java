package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import com.real.realoasis.domain.auth.domain.repository.RefreshTokenRepository;
import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.exception.ExpiredTokenException;
import com.real.realoasis.domain.auth.service.AuthService;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.exception.DuplicateIdException;
import com.real.realoasis.domain.user.exception.PasswordNotMatchException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.global.error.type.ErrorCode;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthConverter authConverter;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenRepository refreshTokenRepository;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TokenDto reissue(String refreshToken) {
        if(jwtTokenProvider.validateToken(refreshToken, JwtTokenProvider.TokenType.REFRESH_TOKEN)){
            throw new ExpiredTokenException(ErrorCode.EXPIRATION_TOKEN_EXCEPTION);
        }

        User user = userFacade.findUserById(jwtTokenProvider.getTokenSubject(refreshToken, JwtTokenProvider.TokenType.REFRESH_TOKEN));
        RefreshToken existingRefreshToken = refreshTokenRepository.findByToken(refreshToken);
        TokenDto tokenDto = makeTokenDto(user);

        refreshTokenRepository.save(authConverter.toEntity(existingRefreshToken.getUserId(), tokenDto.getRefreshToken()));

        return tokenDto;
    }

    @Transactional
    @Override
    public void searchPW(SearchPwDto searchPwDto) {
        User user = userFacade.findUserByEmail(searchPwDto.getEmail());
        if(!searchPwDto.getNewPassword().equals(searchPwDto.getCheckPassword())){
            throw new PasswordNotMatchException(ErrorCode.PASSWORD_NOT_MATCH_EXCEPTION);
        }
        user.updatePassword(passwordEncoder.encode(searchPwDto.getNewPassword()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CoupleCodeDto signUp(SignupDto signupDto) {
        if(userFacade.existsById(signupDto.getId())){
            throw new DuplicateIdException(ErrorCode.DUPLICATE_ID_EXCEPTION);
        }

        String code = makeRandomCode();
        User user = authConverter.toEntity(signupDto, code);

        userFacade.saveUser(user);
        return authConverter.toDto(code);
    }

    private String makeRandomCode() {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    key.append((char) (random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) (random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        return key.toString();
    }
    private TokenDto makeTokenDto(User user){
        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getId());
        LocalDateTime accessExp = jwtTokenProvider.getAccessTokenExpiredTime();
        LocalDateTime refreshExp = jwtTokenProvider.getRefreshTokenExpiredTime();

        return authConverter.toDto(accessToken, refreshToken, accessExp, refreshExp, user);
    }
}
