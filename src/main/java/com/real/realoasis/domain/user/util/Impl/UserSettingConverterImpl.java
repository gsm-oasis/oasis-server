package com.real.realoasis.domain.user.util.Impl;

import com.real.realoasis.domain.user.data.dto.SettingResDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.response.SettingResponse;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSettingConverterImpl implements UserSettingConverter {
    @Override
    public SettingResDto toSettingResDto(User user) {
        return SettingResDto.builder()
                .anniversaryDate(user.getAnniversaryDate())
                .myCode(user.getCode())
                .version("1.0")
                .build();
    }

    @Override
    public SettingResponse toSettingResponse(SettingResDto settingResDto) {
        return SettingResponse.builder()
                .anniversaryDate(settingResDto.getAnniversaryDate())
                .myCode(settingResDto.getMyCode())
                .version(settingResDto.getVersion())
                .build();
    }
}
