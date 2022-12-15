package com.real.realoasis.domain.questionAnswer.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerResponse {
    private String content;
    private String userName;
    private String coupleName;
    private String answer1;
    private String answer2;
}
