package com.real.realoasis.domain.heart.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.couple.exception.CoupleNotFoundException;
import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.service.GetHeartService;
import com.real.realoasis.domain.heart.util.HeartConverter;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import com.sun.jdi.PrimitiveValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHeartServiceImpl implements GetHeartService {
    private final UserFacade userFacade;
    private final HeartConverter heartConverter;
    private final CoupleRepository coupleRepository;

    @Override
    public HeartResponse getHeart() {
        User currentUser = userFacade.currentUser();
        Couple foundCouple = null;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
        }

        HeartDto heartDto = heartConverter.toDto(foundCouple);
        return heartConverter.toResponse(heartDto);
    }
}
