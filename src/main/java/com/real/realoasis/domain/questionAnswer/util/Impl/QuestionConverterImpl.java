package com.real.realoasis.domain.questionAnswer.util.Impl;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverterImpl implements QuestionAnswerConverter {
    @Override
    public CreateDto toDto(QuestionAnswerWriteRequest questionAnswerRequest) {
        return CreateDto.builder()
                .answer(questionAnswerRequest.getAnswer())
                .build();
    }

    @Override
    public QuestionAnswer toEntity(CreateDto createDto, Question question, User currentUser) {
        return QuestionAnswer.builder()
                .answer(createDto.getAnswer())
                .question(question)
                .user(currentUser)
                .build();
    }
}
