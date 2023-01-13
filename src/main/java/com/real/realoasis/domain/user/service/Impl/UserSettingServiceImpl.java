package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.data.dto.SettingResDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.data.response.SettingResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.UserSettingService;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSettingServiceImpl implements UserSettingService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final UserSettingConverter userSettingConverter;



    @Override
    public SettingResponse getSetting() {
        User user = userFacade.currentUser();
        SettingResDto settingResDto = userSettingConverter.toSettingResDto(user);
        return userSettingConverter.toSettingResponse(settingResDto);
    }

    @Override
    public void nicknameChange(NicknameChangeDto nicknameChangeDto) {
        User currentUser = userFacade.currentUser();
        currentUser.updateNickname(nicknameChangeDto.getNickname());
        userFacade.saveUser(currentUser);
    }

    @Override
    public void passwordChange(PasswordChangeDto passwordChangeDto) {
        User currentUser = userFacade.currentUser();
        currentUser.updatePassword(passwordEncoder.encode(passwordChangeDto.getPassword()));
        userFacade.saveUser(currentUser);
    }

    @Override
    public void anniversaryTimeChange(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateAnniversaryTime(anniversaryTimeChangeRequest.getAnniversaryTime());
        userFacade.saveUser(currentUser);
    }
}
