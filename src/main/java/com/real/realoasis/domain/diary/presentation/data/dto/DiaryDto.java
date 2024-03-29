package com.real.realoasis.domain.diary.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class DiaryDto {
    private final Long diaryId;
    private final String content;
    private final String title;
    private final String writer;
    private final String createDate;
}
