package com.real.realoasis.domain.couple.service.impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.couple.service.EnterDatingDateService;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EnterDatingDateServiceImpl implements EnterDatingDateService {
    private final UserFacade userFacade;
    private final CoupleRepository coupleRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enter(EnterDto enterDto) {
        User currentUser = userFacade.currentUser();
        Couple foundCouple = null;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
        }
        Objects.requireNonNull(foundCouple).updateStartDay(enterDto.getStartDay());

        foundCouple.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(foundCouple.getStartDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(foundCouple.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        foundCouple.updateDatingDate(datingDate);
    }
}
