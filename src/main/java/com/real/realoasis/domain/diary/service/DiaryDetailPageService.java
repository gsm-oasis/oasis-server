package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.response.DiaryDetailPageResponse;

public interface DiaryDetailPageService {
    DiaryDetailPageResponse getDetailPage(Long diaryId);
}
