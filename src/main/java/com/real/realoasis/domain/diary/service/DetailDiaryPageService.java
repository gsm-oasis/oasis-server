package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.response.DetailDiaryPageResponse;

public interface DetailDiaryPageService {
    DetailDiaryPageResponse getDetailPage(Long diaryId);
}
