package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.response.DiaryListResponse;

public interface GetDiaryDetailService {
    DiaryDetailResponse get(Long diaryId);
}
