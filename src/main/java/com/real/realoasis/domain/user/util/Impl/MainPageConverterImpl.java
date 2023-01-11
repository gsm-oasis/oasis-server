package com.real.realoasis.domain.user.util.Impl;

import com.real.realoasis.domain.diary.service.DiaryService;
import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.user.data.dto.EnterDto;
import com.real.realoasis.domain.user.data.dto.MainPageDto;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.data.response.MainPageResponse;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.util.MainPageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainPageConverterImpl implements MainPageConverter {
    private final UserFacade userFacade;
    private final DiaryService diaryService;

    @Override
    public MainPageDto toDto(User currentUser, User coupleUser, long datingDate, Question question) {
        return MainPageDto.builder()
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

    @Override
    public MainPageResponse toResponse(MainPageDto mainPageDto) {
        return MainPageResponse.builder()
                .nickname(mainPageDto.getNickname())
                .coupleNickname(mainPageDto.getCoupleNickname())
                .heartLevel(mainPageDto.getHeartLevel())
                .datingDate(mainPageDto.getDatingDate())
                .anniversary(mainPageDto.getAnniversary())
                .questionId(mainPageDto.getQuestionId())
                .content(mainPageDto.getContent())
                .diaryListPageResponse(mainPageDto.getDiaryListPageResponse())
                .build();
    }

    @Override
    public EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest) {
        return EnterDto.builder()
                .firstDay(datingDateEnterRequest.getFirstDay())
                .build();
    }

}
