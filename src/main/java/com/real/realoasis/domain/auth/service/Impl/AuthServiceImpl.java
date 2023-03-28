package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.exception.ExpiredTokenException;
import com.real.realoasis.domain.auth.exception.InvalidTokenException;
import com.real.realoasis.domain.auth.service.AuthService;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.exception.DuplicateIdException;
import com.real.realoasis.domain.user.exception.PasswordNotMatchException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import com.real.realoasis.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, Object> redisTemplate;
    private final AuthConverter authConverter;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TokenDto login(LoginDto loginDto) {
        User user = userFacade.findUserById(loginDto.getId());
        userFacade.checkPassword(user, loginDto.getPassword());

        return makeTokenDto(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TokenDto reissue(String refreshToken) {
        if(jwtTokenProvider.validateToken(refreshToken)){
            throw new ExpiredTokenException(ErrorCode.EXPIRATION_TOKEN_EXCEPTION);
        }

        User user = userFacade.findUserById(jwtTokenProvider.getUserPk(refreshToken));

        String redisRefreshToken = (String) redisTemplate.opsForValue().get("refresh:" + user.getId());

        if(Objects.equals(redisRefreshToken, refreshToken)){
            throw new InvalidTokenException(ErrorCode.INVALID_TOKEN_EXCEPTION);
        }

        return makeTokenDto(user);
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
    public AuthCodeDto signUp(SignupDto signupDto) {
        if(userFacade.existsById(signupDto.getId())){
            throw new DuplicateIdException(ErrorCode.DUPLICATE_ID_EXCEPTION);
        }

        User user = authConverter.toEntity(signupDto);
        String code = makeRandomCode();

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
        Long expiredAt = jwtTokenProvider.getExpiredTime(accessToken);

        redisTemplate.opsForValue()
                .set("RefreshToken:" + user.getId(), refreshToken,
                        jwtTokenProvider.getExpiredTime(refreshToken), TimeUnit.MILLISECONDS);

        return authConverter.toDto(accessToken, refreshToken, expiredAt, user);
    }
}
