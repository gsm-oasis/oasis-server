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
    private final HeartUtil heartUtil;
    private final CoupleConverter mainPageConverter;
    private final CoupleRepository coupleRepository;

    @Transactional
    @Override
    public MainPageDto getMainPage() {
        User currentUser = userFacade.currentUser();
        Couple foundCouple = null;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
        }
        Objects.requireNonNull(foundCouple).today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(foundCouple.getStartDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(foundCouple.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        foundCouple.updateDatingDate(datingDate);
        heartUtil.heartLevel(foundCouple);

        Question question = questionAnswerFacade.findQuestionByQuestionId(datingDate - foundCouple.getDatingDate()+1);

        return mainPageConverter.toDto(foundCouple, question);
    }


}
