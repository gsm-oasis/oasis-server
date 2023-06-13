package com.real.realoasis.domain.questionAnswer.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateDto {
    private final String answer;
}
