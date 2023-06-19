package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleResDto;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;

public interface ConnectCoupleService {
    ConnectCoupleResDto connectCouple(ConnectCoupleDto connectCoupleDto);
}
