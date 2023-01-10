package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.service.AnniversaryTimeChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnniversaryTimeChangeServiceImpl implements AnniversaryTimeChangeService {
    private final UserFacade userFacade;

    @Override
    public void anniversaryTimeChange(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateAnniversaryTime(anniversaryTimeChangeRequest.getAnniversaryTime());
        userFacade.saveUser(currentUser);
    }
}
