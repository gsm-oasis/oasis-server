package com.real.realoasis.domain.questionAnswer.presentation.data.request;

import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerWriteRequest {
    private String answer;
}
