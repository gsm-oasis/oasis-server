package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;

public interface GetMainPageService {
    QuestionAnswerResponse getMainpage(Long questionId);
}
