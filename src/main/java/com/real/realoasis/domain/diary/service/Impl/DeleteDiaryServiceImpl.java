package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.service.DeleteDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteDiaryServiceImpl implements DeleteDiaryService {
    private final DiaryFacade diaryFacade;

    @Override
    public void deleteDiary(Long diaryId) {
        diaryFacade.deleteDiary(diaryId);
    }
}
