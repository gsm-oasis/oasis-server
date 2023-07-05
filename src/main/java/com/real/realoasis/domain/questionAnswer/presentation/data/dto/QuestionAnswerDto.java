package com.real.realoasis.domain.questionAnswer.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
@Builder
public class QuestionAnswerDto {
    private final String userName;
    private final String coupleName;
    private final Optional<String> answer;
    private final Optional<String> coupleAnswer;
}
