package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.response.SettingResponse;
import com.real.realoasis.domain.user.service.GetSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetSettingServiceImpl implements GetSettingService {
    private final UserFacade userFacade;

    @Override
    public SettingResponse getSetting() {
        User user = userFacade.currentUser();
        return SettingResponse.builder()
                .anniversaryTime(user.getAnniversaryTime())
                .questionTime(user.getQuestionTime())
                .myCode(user.getCode())
                .build();
    }
}
