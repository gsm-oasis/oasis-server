package com.real.realoasis.domain.user.util;

import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;

public interface UserConverter {

    ConnectCoupleDto toDto(ConnectCoupleRequest connectCoupleRequest);

    ConnectCoupleResDto toResDto(User coupleUser);

    ConnectCoupleResponse toResponse(ConnectCoupleResDto connectCoupleResDto);

    Couple toEntity(User currentUser, User coupleUser, Heart heart, String registeredDay);

    CoupleAnniversaryDate toEntity(String anniversaryDate, Couple couple);
}
