package com.real.realoasis.domain.questionAnswer.presentation.dto.request;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import com.real.realoasis.domain.user.entity.User;
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

    public QuestionAnswer toEntity(Question question, User user){
        return QuestionAnswer.builder()
                .answer(answer)
                .question(question)
                .user(user)
                .build();
    }
}
