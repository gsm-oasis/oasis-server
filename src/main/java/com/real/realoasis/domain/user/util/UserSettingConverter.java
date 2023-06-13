package com.real.realoasis.domain.user.util;

import com.real.realoasis.domain.user.presentation.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.SettingResDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;

public interface UserSettingConverter {
    SettingResDto toSettingResDto(User user);

    SettingResponse toSettingResponse(SettingResDto settingResDto);

    NicknameChangeDto toNicknameChangeDto(NicknameChangeRequest nicknameChangeRequest);

    PasswordChangeDto toPasswordChangeDto(PasswordChangeRequest passwordChangeRequest);

    AnniversaryTimeChangeDto toAnniversaryTimeChangeDto(AnniversaryTimeChangeRequest anniversaryDateChangeRequest);
}
