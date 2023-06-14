package com.real.realoasis.domain.couple.service.impl;

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

@Service
@RequiredArgsConstructor
public class EnterDatingDateServiceImpl implements EnterDatingDateService {
    private final UserFacade userFacade;

    @Transactional
    @Override
    public void enter(EnterDto enterDto) {
        User currentUser = userFacade.currentUser();
        currentUser.createFirstDay(enterDto.getFirstDay());

        currentUser.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(currentUser.getFirstDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(currentUser.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        currentUser.updateDatingDate(datingDate);

        userFacade.saveUser(currentUser);
    }
}
