package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.user.data.dto.EnterDto;
import com.real.realoasis.domain.user.data.dto.MainPageDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.response.MainPageResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.MainPageService;
import com.real.realoasis.domain.user.util.MainPageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final HeartUtil heartUtil;
    private final MainPageConverter mainPageConverter;

    @Transactional
    @Override
    public MainPageResponse getMainPage() {
        User currentUser = userFacade.currentUser();

        currentUser.today();

        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(currentUser.getFirstDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(currentUser.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        currentUser.updateDatingDate(datingDate);
        heartUtil.heartLevel(currentUser);

        Question question = questionAnswerFacade.findQuestionByQuestionId(datingDate - currentUser.getDatingDate()+1);

        MainPageDto mainPageDto = mainPageConverter.toDto(currentUser, coupleUser, datingDate, question);
        return mainPageConverter.toResponse(mainPageDto);
    }

    @Transactional
    @Override
    public void datingDateEnter(EnterDto enterDto) {
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
