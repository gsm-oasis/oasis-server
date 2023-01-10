package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.service.PasswordChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordChangeServiceImpl implements PasswordChangeService {
    private final UserFacade userFacade;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void passwordChange(PasswordChangeRequest passwordChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updatePassword(passwordEncoder.encode(passwordChangeRequest.getPassword()));
        userFacade.saveUser(currentUser);
    }
}
