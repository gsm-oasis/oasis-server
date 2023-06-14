package com.real.realoasis.domain.user.util.Impl;

import com.real.realoasis.domain.user.presentation.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.SettingResDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;
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
                .myCode(user.getCoupleCode())
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

    @Override
    public NicknameChangeDto toNicknameChangeDto(NicknameChangeRequest nicknameChangeRequest) {
        return NicknameChangeDto.builder()
                .nickname(nicknameChangeRequest.getNickname())
                .build();
    }

    @Override
    public PasswordChangeDto toPasswordChangeDto(PasswordChangeRequest passwordChangeRequest) {
        return PasswordChangeDto.builder()
                .originalPassword(passwordChangeRequest.getOriginalPassword())
                .password(passwordChangeRequest.getPassword())
                .build();
    }

    @Override
    public AnniversaryTimeChangeDto toAnniversaryTimeChangeDto(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest) {
        return AnniversaryTimeChangeDto.builder()
                .anniversaryTime(anniversaryTimeChangeRequest.getAnniversaryTime())
                .build();
    }
}
