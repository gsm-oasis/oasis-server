package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.auth.data.request.SearchPWRequest;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;
import com.real.realoasis.domain.auth.service.SearchPWService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchPWServiceImpl implements SearchPWService {
    private final UserFacade userFacade;

    @Override
    public SearchPWResponse searchPW(SearchPWRequest searchPWRequest) {
        User user = userFacade.findUserById(searchPWRequest.getId());
        String pw = user.getPassword();
        return SearchPWResponse.builder()
                .password(pw)
                .build();
    }
}
