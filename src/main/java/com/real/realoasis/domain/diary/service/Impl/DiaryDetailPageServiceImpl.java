package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.service.DiaryDetailPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryDetailPageServiceImpl implements DiaryDetailPageService {
    private final DiaryFacade diaryFacade;

    @Override
    public DiaryDetailPageResponse getDetailPage(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        return new DiaryDetailPageResponse(diary.getTitle(), diary.getContent(), diary.getMood(), diary.getWriter(), diary.getPhoto());
    }
}
