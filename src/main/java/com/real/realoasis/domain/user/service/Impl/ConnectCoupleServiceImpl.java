package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import com.real.realoasis.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectCoupleServiceImpl implements ConnectCoupleService {
    private final UserFacade userFacade;
    private final UserConverter userConverter;

    @Override
    public ConnectCoupleResponse connectCouple(ConnectCoupleDto connectCoupleDto) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserByCode(connectCoupleDto.getCode());

        currentUser.updateCoupleId(coupleUser.getId());
        currentUser.updateIsCouple();

        userFacade.saveUser(currentUser);

        ConnectCoupleResDto connectCoupleResDto = userConverter.toResDto(coupleUser);
        return userConverter.toResponse(connectCoupleResDto);
    }
}

