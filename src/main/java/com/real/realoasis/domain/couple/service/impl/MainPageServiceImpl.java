package com.real.realoasis.domain.couple.service.impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.anniversary.domain.repository.CoupleAnniversaryDateRepository;
import com.real.realoasis.domain.couple.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
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
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final CoupleConverter coupleConverter;
    private final CoupleAnniversaryDateRepository coupleAnniversaryDateRepository;

    @Transactional
    @Override
    public MainPageDto getMainPage() {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        couple.today();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate startDayToLocalDate = LocalDate.parse(couple.getStartDay(), dateFormat);
        LocalDate todayToLocalDate = LocalDate.parse(couple.getToday(), dateFormat);
        long datingDate = ChronoUnit.DAYS.between(startDayToLocalDate, todayToLocalDate) + 1;
        couple.updateDatingDate(datingDate);

        LocalDate registeredDate = LocalDate.parse(couple.getRegisteredDay(), dateFormat);
        long questionIdx = ChronoUnit.DAYS.between(registeredDate, todayToLocalDate ) + 1;
        Question question = questionAnswerFacade.findQuestionByQuestionId(questionIdx);

        List<CoupleAnniversaryDate> coupleAnniversaryDateList = coupleAnniversaryDateRepository.findAllByCouple(couple);
        LocalDate coupleAnniversaryDate = null;

        if(coupleAnniversaryDateList.size() == 1) {
            LocalDate parsedDate = LocalDate.parse( couple.getToday().substring(0, 4)+ coupleAnniversaryDateList.get(0).getAnniversaryDate(), dateFormat);

            if(parsedDate.compareTo(todayToLocalDate) < 0)
                parsedDate = parsedDate.plusYears(1);
            coupleAnniversaryDate = parsedDate;
        }
        for (int i = 0; i < coupleAnniversaryDateList.size() - 1; i++) {
            LocalDate parsedDate1 = LocalDate.parse( couple.getToday().substring(0, 4)+ coupleAnniversaryDateList.get(i).getAnniversaryDate(), dateFormat);
            LocalDate parsedDate2 = LocalDate.parse( couple.getToday().substring(0, 4) + coupleAnniversaryDateList.get(i+1).getAnniversaryDate(), dateFormat);

            if(parsedDate1.compareTo(todayToLocalDate) < 0)
                parsedDate1 = parsedDate1.plusYears(1);
            else if (parsedDate2.compareTo(todayToLocalDate) < 0)
                parsedDate2 = parsedDate2.plusYears(1);

            if(parsedDate1.isBefore(parsedDate2))
                coupleAnniversaryDate = parsedDate1;
            else
                coupleAnniversaryDate = parsedDate2;
        }

        String mm = Objects.requireNonNull(coupleAnniversaryDate).toString().substring(5, 7);
        String dd = coupleAnniversaryDate.toString().substring(8, 10);
        CoupleAnniversaryDate anniversaryDate = coupleAnniversaryDateRepository.findByAnniversaryDateAndCouple(mm + dd, couple);
        int daysDifference = (int) ChronoUnit.DAYS.between(todayToLocalDate, coupleAnniversaryDate);

        return coupleConverter.toDto(couple, question, daysDifference, currentUser, anniversaryDate);
    }
}
