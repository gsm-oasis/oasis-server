package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.diary.service.DiaryListPageService;
import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.response.MainPageResponse;
import com.real.realoasis.domain.user.service.GetMainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final DiaryListPageService diaryListPageService;
    private final QuestionAnswerFacade questionAnswerFacade;

    @Override
    public MainPageResponse getMainPage() {
        User currentUser = userFacade.currentUser();

        currentUser.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate firstDayToLocalDate = LocalDate.parse(currentUser.getFirstDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(currentUser.getToday(), dateFormat);

        long datingDate = ChronoUnit.DAYS.between(firstDayToLocalDate, todayToLocalDate);

        Question question = questionAnswerFacade.findQuestionByQuestionId(datingDate - currentUser.getDatingDate());

        return MainPageResponse.builder()
                .heartLevel(currentUser.getHeart().getLevel())
                .datingDate(datingDate)
                .questionId(question.getId())
                .content(question.getContent())
                .diaryListPageResponse(diaryListPageService.getList())
                .build();
    }
}
