package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;

public interface GetMainPageService {
    QuestionAnswerDto getMainpage(Long questionId);
}
