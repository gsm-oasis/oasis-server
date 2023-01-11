package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.data.response.SettingResponse;

public interface UserSettingService {
    SettingResponse getSetting();
    void nicknameChange(NicknameChangeRequest nicknameChangeRequest);
    void passwordChange(PasswordChangeRequest passwordChangeRequest);
    void anniversaryTimeChange(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest);

}
