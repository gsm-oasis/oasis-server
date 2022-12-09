package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.diary.service.DiaryListPageService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.response.MainPageResponse;
import com.real.realoasis.domain.user.service.GetMainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final DiaryListPageService diaryListPageService;

    @Override
    public MainPageResponse getMainPage() {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());
        return MainPageResponse.builder()
                .userName(currentUser.getNickName())
                .coupleName(coupleUser.getNickName())
                .datingDate(currentUser.getDatingDate())
                .questionId(1L)
                .content("아직안만듬")
                .diaryListPageResponse(diaryListPageService.getList())
                .build();
    }
}
