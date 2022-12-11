package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectCoupleServiceImpl implements ConnectCoupleService {
    private final UserFacade userFacade;

    @Override
    public void connectCouple(ConnectCoupleRequest connectCoupleRequest) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserByCode(connectCoupleRequest.getCode());

        currentUser.updateCoupleId(coupleUser.getId());

        userFacade.saveUser(currentUser);
    }
}
