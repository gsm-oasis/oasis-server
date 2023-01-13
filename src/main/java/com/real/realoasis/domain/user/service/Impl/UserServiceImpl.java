package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.domain.user.service.UserService;
import com.real.realoasis.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public void withdrawal() {
        User user = userFacade.currentUser();
        userRepository.delete(user);
    }

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
