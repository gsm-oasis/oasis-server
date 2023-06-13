package com.real.realoasis.domain.diary.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class CreateDiaryDto {
    private final String title;
    private final String content;
    private final String mood;
    private final String writer;
}
