package com.real.realoasis.domain.couple.util.impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.service.GetDiaryListService;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.couple.util.CoupleConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoupleConverterImpl implements CoupleConverter {
    private final UserFacade userFacade;
    private final GetDiaryListService getDiaryListService;

    @Override
    public MainPageDto toDto(Couple couple, Question question) {
        return MainPageDto.builder()
                .nickname(couple.getUserA().getNickname())
                .coupleNickname(couple.getUserB().getNickname())
                .heartLevel(couple.getHeart().getLevel())
                .datingDate(couple.getDatingDate())
                .anniversary(userFacade.getAnniversary(couple.getDatingDate()))
                .questionId(question.getIdx())
                .content(question.getContent())
                .diaryListDtoList(getDiaryListService.getList())
                .build();
    }

    @Override
    public MainPageResponse toResponse(MainPageDto mainPageDto, DiaryListResponse diaryResponseList) {
        return MainPageResponse.builder()
                .nickname(mainPageDto.getNickname())
                .coupleNickname(mainPageDto.getCoupleNickname())
                .heartLevel(mainPageDto.getHeartLevel())
                .datingDate(mainPageDto.getDatingDate())
                .anniversary(mainPageDto.getAnniversary())
                .questionId(mainPageDto.getQuestionId())
                .content(mainPageDto.getContent())
                .diarys(diaryResponseList)
                .build();
    }

    @Override
    public EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest) {
        return EnterDto.builder()
                .startDay(datingDateEnterRequest.getStartDay())
                .build();
    }

}