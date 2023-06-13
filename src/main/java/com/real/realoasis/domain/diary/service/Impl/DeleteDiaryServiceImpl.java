package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.service.DeleteDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteDiaryServiceImpl implements DeleteDiaryService {
    private final DiaryFacade diaryFacade;
    @Override
    public void delete(Long diaryId) {
        diaryFacade.deleteDiary(diaryId);
    }
}
