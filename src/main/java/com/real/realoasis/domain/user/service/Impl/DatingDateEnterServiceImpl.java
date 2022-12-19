package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.service.DatingDateEnterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class DatingDateEnterServiceImpl implements DatingDateEnterService {
    private final UserFacade userFacade;

    @Override
    public void datingDateEnter(DatingDateEnterRequest datingDateEnterRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.createFirstDay(datingDateEnterRequest.getFirstDay());

        currentUser.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(currentUser.getFirstDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(currentUser.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        currentUser.updateDatingDate(datingDate);

        userFacade.saveUser(currentUser);
    }
}
