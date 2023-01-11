package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;

public interface UserService {
    void withdrawal();
    ConnectCoupleResponse connectCouple(ConnectCoupleRequest connectCoupleRequest);

}
