package com.real.realoasis.domain.diary.service;


import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;

public interface DiaryEditService {
    void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest);
}
