package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.service.SignUpService;
import com.real.realoasis.domain.user.exception.DuplicateEmailException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserFacade userFacade;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRequest signupRequest) {
        if(userFacade.existsById(signupRequest.getEmail())){
            throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL_EXCEPTION);
        }
        userFacade.saveUser(signupRequest);
    }
}
