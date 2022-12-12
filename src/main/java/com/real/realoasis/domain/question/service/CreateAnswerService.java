package com.real.realoasis.domain.question.service;


import com.real.realoasis.domain.question.presentation.dto.request.QuestionAnswerRequest;

public interface CreateAnswerService {
    void createAnswer(QuestionAnswerRequest questionAnswerRequest, Long questionId);
}
