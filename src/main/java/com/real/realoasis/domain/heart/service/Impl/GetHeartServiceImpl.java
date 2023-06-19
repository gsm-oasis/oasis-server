package com.real.realoasis.domain.heart.service.Impl;

import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.service.GetHeartService;
import com.real.realoasis.domain.heart.util.HeartConverter;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHeartServiceImpl implements GetHeartService {
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
