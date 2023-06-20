package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.domain.repository.UserRepository;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import com.real.realoasis.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectCoupleServiceImpl implements ConnectCoupleService {
    private final UserFacade userFacade;
    private final UserConverter userConverter;
    private final CoupleRepository coupleRepository;
    private final UserRepository userRepository;

    @Override
    public ConnectCoupleResDto connectCouple(ConnectCoupleDto connectCoupleDto) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userRepository.findByCoupleCode(connectCoupleDto.getCode());

        coupleRepository.save(userConverter.toEntity(currentUser, coupleUser));
        currentUser.updateIsCouple();

        return userConverter.toResDto(coupleUser);
    }
}

