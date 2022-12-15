package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.service.NicknameChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NicknameChangeServiceImpl implements NicknameChangeService {
    private final UserFacade userFacade;

    @Override
    public void nicknameChange(NicknameChangeRequest nicknameChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateNickname(nicknameChangeRequest.getNickname());
        userFacade.saveUser(currentUser);
    }
}
