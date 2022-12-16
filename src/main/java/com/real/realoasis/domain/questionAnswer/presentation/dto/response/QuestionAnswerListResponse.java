package com.real.realoasis.domain.questionAnswer.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerListResponse {
    private Long questionId;
    private String content;
}
