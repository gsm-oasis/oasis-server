package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.service.DiaryEditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DiaryEditServiceImpl implements DiaryEditService {
    private final DiaryFacade diaryFacade;

    @Override
    public void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest) {
        Diary editDiary = diaryFacade.findDiaryById(diaryId);
        editDiary.update(editDiaryRequest.getTitle(), editDiaryRequest.getContent(), editDiaryRequest.getMood());
        diaryFacade.saveDiary(editDiary);
    }
}
