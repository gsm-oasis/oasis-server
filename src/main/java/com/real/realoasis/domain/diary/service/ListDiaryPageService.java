package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.response.ListDiaryPageResponse;

import java.util.stream.Stream;

public interface ListDiaryPageService {
    Stream<ListDiaryPageResponse> getList();
}
