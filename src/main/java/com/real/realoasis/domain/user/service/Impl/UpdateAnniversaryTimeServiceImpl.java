package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.service.UpdateAnniversaryTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAnniversaryTimeServiceImpl implements UpdateAnniversaryTimeService {
    private final UserFacade userFacade;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AnniversaryTimeChangeDto anniversaryTimeChangeDto) {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();

        couple.updateAnniversaryTime(anniversaryTimeChangeDto.getAnniversaryTime());
    }
}
