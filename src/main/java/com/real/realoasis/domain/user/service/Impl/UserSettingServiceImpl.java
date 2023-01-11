package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.data.response.SettingResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.UserSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSettingServiceImpl implements UserSettingService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;



    @Override
    public SettingResponse getSetting() {
        User user = userFacade.currentUser();
        return SettingResponse.builder()
                .anniversaryTime(user.getAnniversaryDate())
                .myCode(user.getCode())
                .build();
    }

    @Override
    public void nicknameChange(NicknameChangeRequest nicknameChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateNickname(nicknameChangeRequest.getNickname());
        userFacade.saveUser(currentUser);
    }

    @Override
    public void passwordChange(PasswordChangeRequest passwordChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updatePassword(passwordEncoder.encode(passwordChangeRequest.getPassword()));
        userFacade.saveUser(currentUser);
    }

    @Override
    public void anniversaryTimeChange(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateAnniversaryTime(anniversaryTimeChangeRequest.getAnniversaryTime());
        userFacade.saveUser(currentUser);
    }
}
