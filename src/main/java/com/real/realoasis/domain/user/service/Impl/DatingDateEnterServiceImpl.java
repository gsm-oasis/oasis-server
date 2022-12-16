package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.service.DatingDateEnterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DatingDateEnterServiceImpl implements DatingDateEnterService {
    private final UserFacade userFacade;

    @Override
    public void datingDateEnter(DatingDateEnterRequest datingDateEnterRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.today();
        currentUser.createFirstDay(datingDateEnterRequest.getFirstDay());
        userFacade.saveUser(currentUser);
    }
}
