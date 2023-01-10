package com.real.realoasis.domain.questionAnswer.util;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.user.data.entity.User;

public interface QuestionAnswerConverter {
    CreateDto toDto(QuestionAnswerWriteRequest questionAnswerRequest);

    QuestionAnswer toEntity(CreateDto createDto,Question question, User currentUser);
}
