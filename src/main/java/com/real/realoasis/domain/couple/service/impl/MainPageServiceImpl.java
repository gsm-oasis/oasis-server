package com.real.realoasis.domain.couple.service.impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.couple.service.MainPageService;
import com.real.realoasis.domain.couple.util.CoupleConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final CoupleConverter mainPageConverter;

    @Transactional
    @Override
    public MainPageDto getMainPage() {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();

        couple.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(couple.getStartDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(couple.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        couple.updateDatingDate(datingDate);

        Question question = questionAnswerFacade.findQuestionByQuestionId(datingDate - couple.getDatingDate()+1);

        return mainPageConverter.toDto(couple, question);
    }


}
