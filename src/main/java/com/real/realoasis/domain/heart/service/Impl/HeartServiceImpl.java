package com.real.realoasis.domain.heart.service.Impl;

import com.real.realoasis.domain.heart.data.dto.HeartDto;
import com.real.realoasis.domain.heart.data.response.HeartResponse;
import com.real.realoasis.domain.heart.service.HeartService;
import com.real.realoasis.domain.heart.util.HeartConverter;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {
    private final UserFacade userFacade;
    private final HeartConverter heartConverter;
    private final HeartUtil heartUtil;

    @Override
    public HeartResponse getHeart() {
        User user = userFacade.currentUser();

        heartUtil.heartLevel(user);

        HeartDto heartDto = heartConverter.toDto(user.getHeart().getLevel());
        return heartConverter.toResponse(heartDto);
    }
}
