package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.response.DiaryListPageResponse;
import com.real.realoasis.domain.diary.service.DiaryListPageService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DiaryListPageServiceImpl implements DiaryListPageService {
    private final DiaryFacade diaryFacade;
    private final UserFacade userFacade;


    @Override
    public Stream<DiaryListPageResponse> getList() {
        User currentUser = userFacade.currentUser();

        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        List<DiaryListPageResponse> list = new ArrayList<>();

        diaryFacade.findAllByUserId(currentUser.getId()).forEach(diary -> {
            Long diaryId = diary.getId();
            String content = diary.getContent();
            String title = diary.getTitle();
            String writer = diary.getWriter();
            String createDate = diary.getCreateDate();
            list.add(new DiaryListPageResponse(diaryId, content, title, writer, createDate));
        });
        diaryFacade.findAllByUserId(coupleUser.getId()).forEach(diary -> {
            Long diaryId = diary.getId();
            String content = diary.getContent();
            String title = diary.getTitle();
            String writer = diary.getWriter();
            String createDate = diary.getCreateDate();
            list.add(new DiaryListPageResponse(diaryId, content, title, writer, createDate));
        });
        return list.stream()
                .sorted(Comparator.comparing(DiaryListPageResponse::getDiaryId).reversed());
    }
}
