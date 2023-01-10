package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;

public interface ConnectCoupleService {
    ConnectCoupleResponse connectCouple(ConnectCoupleRequest connectCoupleRequest);
}
