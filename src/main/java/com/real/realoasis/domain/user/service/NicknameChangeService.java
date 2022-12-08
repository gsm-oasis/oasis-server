package com.real.realoasis.domain.user.service;


import com.real.realoasis.domain.user.presentation.dto.request.NicknameChangeRequest;

public interface NicknameChangeService {
    void nicknameChange(NicknameChangeRequest nicknameChangeRequest);
}
