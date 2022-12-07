package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.response.ListDiaryPageResponse;

import java.util.List;

public interface ListDiaryPageService {
    List<ListDiaryPageResponse> getList();
}
