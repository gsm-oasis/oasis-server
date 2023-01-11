package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.data.response.MainPageResponse;

public interface MainPageService {
    MainPageResponse getMainPage();
    void datingDateEnter(DatingDateEnterRequest datingDateEnterRequest);

}
