package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.data.response.SettingResponse;

public interface UserSettingService {
    SettingResponse getSetting();
    void nicknameChange(NicknameChangeDto nicknameChangeDto);
    void passwordChange(PasswordChangeDto passwordChangeDto);
    void anniversaryTimeChange(AnniversaryTimeChangeDto anniversaryTimeChangeDto);

}
