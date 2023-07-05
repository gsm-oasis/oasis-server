package com.real.realoasis.domain.questionAnswer.util;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.presentation.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface QuestionAnswerConverter {
    CreateDto toDto(QuestionAnswerWriteRequest questionAnswerRequest);

    QuestionAnswer toEntity(CreateDto createDto, Question question, Couple couple, User currentUser);

    QuestionAnswerDto toAnswerDto(User currentUser, User coupleUser, String answer, String coupleAnswer);

    QuestionAnswerResponse toResponse(QuestionAnswerDto questionAnswerDto);

    List<QuestionAnswerListDto> toListDto(List<QuestionAnswer> list);

    QuestionAnswerListResponse toResponse(QuestionAnswerListDto questionAnswerDtoList);
}
