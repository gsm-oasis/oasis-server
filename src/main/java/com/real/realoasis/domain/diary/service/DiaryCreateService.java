package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.request.DiaryCreateRequest;


public interface DiaryCreateService {
    void createDiary(DiaryCreateRequest createDairyRequest) throws Exception;
}
