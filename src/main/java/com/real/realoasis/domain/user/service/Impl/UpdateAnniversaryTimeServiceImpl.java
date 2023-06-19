package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.service.UpdateAnniversaryTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAnniversaryTimeServiceImpl implements UpdateAnniversaryTimeService {
    private final UserFacade userFacade;

    @Override
    public void update(AnniversaryTimeChangeDto anniversaryTimeChangeDto) {
        User currentUser = userFacade.currentUser();
        currentUser.updateAnniversaryTime(anniversaryTimeChangeDto.getAnniversaryTime());
        userFacade.saveUser(currentUser);
    }
}
