package com.real.realoasis.domain.diary.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryResponse {
    private final Long diaryId;
    private final String content;
    private final String title;
    private final String writer;
    private final String createDate;
}

