package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.SettingResDto;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;
import com.real.realoasis.domain.user.service.GetSettingService;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSettingServiceImpl implements GetSettingService {
    private final UserFacade userFacade;
    private final UserSettingConverter userSettingConverter;
    private final CoupleRepository coupleRepository;

    @Override
    public SettingResponse getSetting() {
        User currentUser = userFacade.currentUser();
        Couple foundCouple = null;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
        }

        SettingResDto settingResDto = userSettingConverter.toSettingResDto(currentUser,foundCouple);
        return userSettingConverter.toSettingResponse(settingResDto);
    }
}
