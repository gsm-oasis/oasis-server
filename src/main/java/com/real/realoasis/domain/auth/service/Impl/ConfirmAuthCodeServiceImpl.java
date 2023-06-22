package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import com.real.realoasis.domain.auth.domain.repository.AuthCodeRepository;
import com.real.realoasis.domain.auth.exception.InValidAuthCodeException;
import com.real.realoasis.domain.auth.service.ConfirmAuthCodeService;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmAuthCodeServiceImpl implements ConfirmAuthCodeService {
    private final AuthCodeRepository authCodeRepository;

    @Override
    public void confirmAuthenticationCode(String email, String code) {
        AuthCode authCode = authCodeRepository.findByEmail(email);
        if(!code.equals(authCode.getCode())) {
            throw new InValidAuthCodeException(ErrorCode.INVALID_AUTH_CODE);
        }
    }
}
