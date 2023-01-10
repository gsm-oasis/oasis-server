package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectCoupleServiceImpl implements ConnectCoupleService {
    private final UserFacade userFacade;

    @Override
    public ConnectCoupleResponse connectCouple(ConnectCoupleRequest connectCoupleRequest) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserByCode(connectCoupleRequest.getCode());

        currentUser.updateCoupleId(coupleUser.getId());
        currentUser.updateIsCouple();

        userFacade.saveUser(currentUser);

        return ConnectCoupleResponse.builder()
                .nickname(coupleUser.getNickname())
                .build();
    }
}
