package com.real.realoasis.domain.questionAnswer.presentation.data.response;

import lombok.*;

@Builder
@Getter
@RequiredArgsConstructor
public class QuestionAnswerResponse {
    private final String userName;
    private final String coupleName;
    private final String answer;
    private final String coupleAnswer;
}
