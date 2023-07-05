package com.real.realoasis.domain.questionAnswer.presentation.data.response;

import lombok.*;

import java.util.Optional;

@Builder
@Getter
@RequiredArgsConstructor
public class QuestionAnswerResponse {
    private final String userName;
    private final String coupleName;
    private final Optional<String> answer;
    private final Optional<String> coupleAnswer;
}
