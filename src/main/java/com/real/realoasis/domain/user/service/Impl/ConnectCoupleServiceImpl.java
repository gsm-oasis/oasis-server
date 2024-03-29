package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.domain.heart.domain.repository.HeartRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.domain.repository.UserRepository;
import com.real.realoasis.domain.user.exception.UserCodeNotFoundException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import com.real.realoasis.domain.user.util.UserConverter;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ConnectCoupleServiceImpl implements ConnectCoupleService {
    private final UserFacade userFacade;
    private final UserConverter userConverter;
    private final CoupleRepository coupleRepository;
    private final UserRepository userRepository;
    private final HeartRepository heartRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConnectCoupleResDto connectCouple(ConnectCoupleDto connectCoupleDto) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userRepository.findByCoupleCode(connectCoupleDto.getCode())
                .orElseThrow(() -> new UserCodeNotFoundException(ErrorCode.USER_CODE_NOT_FOUND));
        Heart heart = new Heart(0, 1);
        Couple couple;
        heartRepository.save(heart);

        String registeredDay = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if(coupleUser.getCouple() == null)
            couple = userConverter.toEntity(currentUser, coupleUser, heart, registeredDay);
        else {
            couple = coupleUser.getCouple();
            couple.updateUserB(currentUser);
        }

        coupleRepository.save(couple);

        currentUser.updateIsCouple();
        currentUser.updateCouple(couple);
        return userConverter.toResDto(coupleUser);
    }
}

