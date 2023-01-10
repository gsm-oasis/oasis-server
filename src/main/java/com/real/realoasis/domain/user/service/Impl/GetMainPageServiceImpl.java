package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.diary.service.DiaryService;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.response.MainPageResponse;
import com.real.realoasis.domain.user.service.GetMainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final DiaryService diaryService;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final HeartUtil heartUtil;

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

        Question question = questionAnswerFacade.findQuestionByQuestionId(datingDate - currentUser.getDatingDate());

        return MainPageResponse.builder()
                .nickname(currentUser.getNickname())
                .coupleNickname(coupleUser.getNickname())
                .heartLevel(currentUser.getHeart().getLevel())
                .datingDate(datingDate)
                .anniversary(userFacade.getAnniversary(datingDate))
                .questionId(question.getId())
                .content(question.getContent())
                .diaryListPageResponse(diaryService.getList())
                .build();
    }

}
