package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;

public interface GetQuestionAnswerMainpageService {
    QuestionAnswerResponse getMainpage(Long questionId);
}
