package com.real.realoasis.domain.user.util;

import com.real.realoasis.domain.user.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;

public interface UserConverter {

    ConnectCoupleDto toDto(ConnectCoupleRequest connectCoupleRequest);

    ConnectCoupleResDto toResDto(User coupleUser);

    ConnectCoupleResponse toResponse(ConnectCoupleResDto connectCoupleResDto);
}
