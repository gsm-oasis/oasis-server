package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;

public interface GetDiaryDetailService {
    DiaryDetailResponse get(Long diaryId);
}
