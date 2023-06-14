package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;

public interface GetDiaryDetailService {
    DiaryDetailDto get(Long diaryId);
}
