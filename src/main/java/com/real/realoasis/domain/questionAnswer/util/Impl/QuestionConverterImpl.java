package com.real.realoasis.domain.questionAnswer.util.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.presentation.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    public QuestionAnswer toEntity(CreateDto createDto, Question question, Couple couple, User currentUser) {
        if(currentUser.equals(couple.getUserA()))
            return QuestionAnswer.builder()
                .answerA(createDto.getAnswer())
                .question(question)
                .couple(couple)
                .build();
        else
            return QuestionAnswer.builder()
                    .answerB(createDto.getAnswer())
                    .question(question)
                    .couple(couple)
                    .build();
    }

    @Override
    public QuestionAnswerDto toAnswerDto(User currentUser, User coupleUser, Optional<String> answer, Optional<String> coupleAnswer) {
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
                        questionAnswer.getIdx(),
                        questionAnswer.getQuestion().getContent()
                )
        ).sorted(Comparator.comparing(QuestionAnswerListDto::getQuestionId).reversed()).collect(Collectors.toList());
    }

    @Override
    public QuestionAnswerListResponse toResponse(QuestionAnswerListDto questionAnswerDtoList) {
        return QuestionAnswerListResponse.builder()
                .questionId(questionAnswerDtoList.getQuestionId())
                .content(questionAnswerDtoList.getContent())
                .build();
    }
}
