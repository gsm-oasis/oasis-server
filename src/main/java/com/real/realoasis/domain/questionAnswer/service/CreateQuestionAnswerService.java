package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;

public interface CreateQuestionAnswerService {
    void createQuestionAnswer(CreateDto createDto, Long questionId);
}
