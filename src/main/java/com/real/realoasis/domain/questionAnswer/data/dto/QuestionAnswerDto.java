package com.real.realoasis.domain.questionAnswer.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class QuestionAnswerDto {
    private final String userName;
    private final String coupleName;
    private final String answer;
    private final String coupleAnswer;
}
