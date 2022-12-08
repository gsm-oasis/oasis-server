package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.response.DiaryListPageResponse;

import java.util.stream.Stream;

public interface DiaryListPageService {
    Stream<DiaryListPageResponse> getList();
}
