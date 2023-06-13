package com.real.realoasis.domain.questionAnswer.util.Impl;

import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.presentation.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public QuestionAnswerDto toAnswerDto(User currentUser, User coupleUser, String answer, String coupleAnswer) {
        return QuestionAnswerDto.builder()
                .userName(currentUser.getNickname())
                .coupleName(coupleUser.getNickname())
                .answer(answer)
                .coupleAnswer(coupleAnswer)
                .build();
    }

    @Override
    public QuestionAnswerResponse toResponse(QuestionAnswerDto questionAnswerDto) {
        return QuestionAnswerResponse.builder()
                .userName(questionAnswerDto.getUserName())
                .coupleName(questionAnswerDto.getCoupleName())
                .answer(questionAnswerDto.getAnswer())
                .coupleAnswer(questionAnswerDto.getCoupleAnswer())
                .build();
    }

    @Override
    public List<QuestionAnswerListDto> toListDto(List<QuestionAnswer> list) {
        return list.stream().map(questionAnswer ->
                new QuestionAnswerListDto(
                        questionAnswer.getId(),
                        questionAnswer.getQuestion().getContent()
                )
        ).sorted(Comparator.comparing(QuestionAnswerListDto::getQuestionId).reversed()).collect(Collectors.toList());
    }

    @Override
    public QuestionAnswerListResponse toListResponse(List<QuestionAnswerListDto> questionAnswerDtoList) {
        return QuestionAnswerListResponse.builder()
                .questions(questionAnswerDtoList)
                .build();
    }
}
