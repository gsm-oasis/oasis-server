package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.service.UpdatePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void update(PasswordChangeDto passwordChangeDto) {
        User currentUser = userFacade.currentUser();
        userFacade.checkPassword(currentUser, passwordChangeDto.getOriginalPassword());
        currentUser.updatePassword(passwordEncoder.encode(passwordChangeDto.getPassword()));
    }
}
