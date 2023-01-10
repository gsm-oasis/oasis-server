package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerListResponse;

import java.util.stream.Stream;

public interface GetQuestionAnswerListService {
    Stream<QuestionAnswerListResponse> getList();
}
