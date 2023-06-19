package com.real.realoasis.domain.user.util.Impl;

import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverterImpl implements UserConverter {
    @Override
    public ConnectCoupleDto toDto(ConnectCoupleRequest connectCoupleRequest) {
        return ConnectCoupleDto.builder()
                .code(connectCoupleRequest.getCode())
                .build();
    }

    @Override
    public ConnectCoupleResDto toResDto(User coupleUser) {
        return ConnectCoupleResDto.builder()
                .nickname(coupleUser.getNickname())
                .build();
    }

    @Override
    public ConnectCoupleResponse toResponse(ConnectCoupleResDto connectCoupleResDto) {
        return ConnectCoupleResponse.builder()
                .nickname(connectCoupleResDto.getNickname())
                .build();
    }
}
