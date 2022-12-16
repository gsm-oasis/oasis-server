package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerListResponse;

import java.util.stream.Stream;

public interface GetQuestionAnswerListService {
    Stream<QuestionAnswerListResponse> getList();
}
