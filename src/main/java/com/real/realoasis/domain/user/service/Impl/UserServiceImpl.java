package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Override
    public void withdrawal() {
        User user = userFacade.currentUser();
        userRepository.delete(user);
    }

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
