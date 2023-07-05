package com.real.realoasis.domain.questionAnswer.presentation.data.response;
import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionAnswerListResponse {
    private final Long questionId;
    private final String content;
}
