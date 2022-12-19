package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.dto.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.presentation.dto.response.ConnectCoupleResponse;

public interface ConnectCoupleService {
    ConnectCoupleResponse connectCouple(ConnectCoupleRequest connectCoupleRequest);
}
