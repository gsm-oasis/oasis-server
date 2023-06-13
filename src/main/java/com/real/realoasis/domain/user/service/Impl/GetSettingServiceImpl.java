package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.SettingResDto;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;
import com.real.realoasis.domain.user.service.GetSettingService;
import com.real.realoasis.domain.user.util.UserConverter;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSettingServiceImpl implements GetSettingService {
    private final UserFacade userFacade;
    private final UserSettingConverter userSettingConverter;

    @Override
    public SettingResponse getSetting() {
        User user = userFacade.currentUser();
        SettingResDto settingResDto = userSettingConverter.toSettingResDto(user);
        return userSettingConverter.toSettingResponse(settingResDto);
    }
}
