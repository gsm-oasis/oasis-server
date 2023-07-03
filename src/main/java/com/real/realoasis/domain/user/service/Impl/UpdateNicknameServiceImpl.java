package com.real.realoasis.domain.user.service.Impl;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.service.UpdateNicknameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateNicknameServiceImpl implements UpdateNicknameService {
    private final UserFacade userFacade;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NicknameChangeDto nicknameChangeDto) {
        User currentUser = userFacade.currentUser();
        currentUser.updateNickname(nicknameChangeDto.getNickname());
    }
}
