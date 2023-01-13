package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;

public interface UserService {
    void withdrawal();
    ConnectCoupleResponse connectCouple(ConnectCoupleDto connectCoupleDto);

}
