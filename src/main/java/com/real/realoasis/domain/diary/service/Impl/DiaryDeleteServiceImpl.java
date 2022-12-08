package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.service.DiaryDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryDeleteServiceImpl implements DiaryDeleteService {
    private final DiaryFacade diaryFacade;

    @Override
    public void deleteDiary(Long diaryId) {
        diaryFacade.deleteDiary(diaryId);
    }
}
