package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;

public interface ConnectCoupleService {
    ConnectCoupleResponse connectCouple(ConnectCoupleDto connectCoupleDto);
}
