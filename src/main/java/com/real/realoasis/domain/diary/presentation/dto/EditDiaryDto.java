package com.real.realoasis.domain.diary.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class EditDiaryDto {
    private final String title;
    private final String content;
    private final String mood;
}
