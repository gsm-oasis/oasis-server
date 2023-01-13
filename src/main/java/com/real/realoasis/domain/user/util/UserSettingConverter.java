package com.real.realoasis.domain.user.util;

import com.real.realoasis.domain.user.data.dto.SettingResDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.response.SettingResponse;

public interface UserSettingConverter {
    SettingResDto toSettingResDto(User user);

    SettingResponse toSettingResponse(SettingResDto settingResDto);
}
