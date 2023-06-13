package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;

public interface MainPageService {
    MainPageResponse getMainPage();
    void datingDateEnter(EnterDto enterDto);

}
