package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.response.DetailDiaryPageResponse;
import com.real.realoasis.domain.diary.service.DetailDiaryPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailDiaryPageServiceImpl implements DetailDiaryPageService {
    private final DiaryFacade diaryFacade;

    @Override
    public DetailDiaryPageResponse getDetailPage(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        return new DetailDiaryPageResponse(diary.getTitle(), diary.getContent(), diary.getMood(), diary.getWriter(), diary.getPhoto());
    }
}
