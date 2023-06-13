package com.real.realoasis.domain.questionAnswer.presentation.data.response;

import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import lombok.*;

import java.util.List;


@Getter
@Builder
@RequiredArgsConstructor
public class QuestionAnswerListResponse {
    private final List<QuestionAnswerListDto> questions;
}
