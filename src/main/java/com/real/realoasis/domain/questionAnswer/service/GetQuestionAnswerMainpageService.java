package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerResponse;

public interface GetQuestionAnswerMainpageService {
    QuestionAnswerResponse getMainpage(Long questionId);
}
