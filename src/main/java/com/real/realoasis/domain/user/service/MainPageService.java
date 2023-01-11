package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.dto.EnterDto;
import com.real.realoasis.domain.user.data.response.MainPageResponse;

public interface MainPageService {
    MainPageResponse getMainPage();
    void datingDateEnter(EnterDto enterDto);

}
