package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.service.SignUpService;
import com.real.realoasis.domain.user.exception.DuplicateIdException;
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
    public SignupResponse signUp(SignUpRequest signupRequest) {
        if(userFacade.existsById(signupRequest.getId())){
            throw new DuplicateIdException(ErrorCode.DUPLICATE_ID_EXCEPTION);
        }
        return userFacade.saveUser(signupRequest);

    }
}
