package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
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
    private final CoupleRepository coupleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AnniversaryTimeChangeDto anniversaryTimeChangeDto) {
        User currentUser = userFacade.currentUser();
        Couple foundCouple;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
            foundCouple.updateAnniversaryTime(anniversaryTimeChangeDto.getAnniversaryTime());
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
            foundCouple.updateAnniversaryTime(anniversaryTimeChangeDto.getAnniversaryTime());
        }
    }
}
