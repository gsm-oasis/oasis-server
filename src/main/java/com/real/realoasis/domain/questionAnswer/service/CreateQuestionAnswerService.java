package com.real.realoasis.domain.questionAnswer.service;


import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;

public interface CreateQuestionAnswerService {
    void createQuestionAnswer(QuestionAnswerWriteRequest questionAnswerRequest, Long questionId);
}
