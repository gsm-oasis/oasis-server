package com.real.realoasis.domain.questionAnswer.service;


import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerWriteRequest;

public interface CreateQuestionAnswerService {
    void createQuestionAnswer(QuestionAnswerWriteRequest questionAnswerRequest, Long questionId);
}
