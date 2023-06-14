package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.exception.InValidAuthCodeException;
import com.real.realoasis.domain.auth.service.ConfirmAuthCodeService;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmAuthCodeServiceImpl implements ConfirmAuthCodeService {
    @Override
    public void confirmAuthenticationCode(String code, String sentCode) {
        if(!code.equals(sentCode)) {
            throw new InValidAuthCodeException(ErrorCode.INVALID_AUTH_CODE);
        }
    }
}
