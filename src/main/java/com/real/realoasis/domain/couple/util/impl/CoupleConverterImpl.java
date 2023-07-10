package com.real.realoasis.domain.couple.util.impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryResponse;
import com.real.realoasis.domain.diary.service.GetDiaryListService;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.couple.util.CoupleConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CoupleConverterImpl implements CoupleConverter {
    private final UserFacade userFacade;
    private final GetDiaryListService getDiaryListService;

    @Override
    public MainPageDto toDto(Couple couple, Question question, long daysLeft, User user) {
        if(user.equals(couple.getUserA())) {
            return MainPageDto.builder()
                    .nickname(couple.getUserA().getNickname())
                    .coupleNickname(couple.getUserB().getNickname())
                    .heartLevel(couple.getHeart().getLevel())
                    .datingDate(couple.getDatingDate())
                    .anniversary(userFacade.getAnniversary(couple.getDatingDate()))
                    .daysLeft(daysLeft)
                    .questionId(question.getIdx())
                    .content(question.getContent())
                    .diaryListDtoList(getDiaryListService.getList())
                    .build();
        } else
            return MainPageDto.builder()
                    .nickname(couple.getUserB().getNickname())
                    .coupleNickname(couple.getUserB().getNickname())
                    .heartLevel(couple.getHeart().getLevel())
                    .datingDate(couple.getDatingDate())
                    .anniversary(userFacade.getAnniversary(couple.getDatingDate()))
                    .daysLeft(daysLeft)
                    .questionId(question.getIdx())
                    .content(question.getContent())
                    .diaryListDtoList(getDiaryListService.getList())
                    .build();
    }

    @Override
    public MainPageResponse toResponse(MainPageDto mainPageDto, List<DiaryResponse> diaryResponseList) {
        return MainPageResponse.builder()
                .nickname(mainPageDto.getNickname())
                .coupleNickname(mainPageDto.getCoupleNickname())
                .heartLevel(mainPageDto.getHeartLevel())
                .datingDate(mainPageDto.getDatingDate())
                .anniversary(mainPageDto.getAnniversary())
                .daysLeft(mainPageDto.getDaysLeft())
                .questionId(mainPageDto.getQuestionId())
                .content(mainPageDto.getContent())
                .diaries(diaryResponseList)
                .build();
    }

    @Override
    public EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest) {
        return EnterDto.builder()
                .startDay(datingDateEnterRequest.getStartDay())
                .build();
    }

}
