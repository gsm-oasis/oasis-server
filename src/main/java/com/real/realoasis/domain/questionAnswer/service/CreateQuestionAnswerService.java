package com.real.realoasis.domain.questionAnswer.service;


import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerRequest;

public interface CreateQuestionAnswerService {
    void createQuestionAnswer(QuestionAnswerRequest questionAnswerRequest, Long questionId);
}
