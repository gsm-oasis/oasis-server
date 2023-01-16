package com.real.realoasis.domain.questionAnswer.util;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.data.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.user.data.entity.User;

import java.util.List;

public interface QuestionAnswerConverter {
    CreateDto toDto(QuestionAnswerWriteRequest questionAnswerRequest);

    QuestionAnswer toEntity(CreateDto createDto,Question question, User currentUser);

    QuestionAnswerDto toAnswerDto(User currentUser, User coupleUser, String answer, String coupleAnswer);

    QuestionAnswerResponse toResponse(QuestionAnswerDto questionAnswerDto);

    List<QuestionAnswerListDto> toListDto(List<QuestionAnswer> list);

    QuestionAnswerListResponse toListResponse(List<QuestionAnswerListDto> questionAnswerDtoList);
}
