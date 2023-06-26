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
    private final HeartUtil heartUtil;

    @Override
    public HeartDto getHeart() {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        int max = heartUtil.getMax(couple.getHeart().getLevel());

        return heartConverter.toDto(couple, max);
    }
}
