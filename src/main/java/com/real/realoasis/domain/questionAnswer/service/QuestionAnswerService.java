package com.real.realoasis.domain.questionAnswer.service;


import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;

import java.util.List;
import java.util.stream.Stream;

public interface QuestionAnswerService {
    void createQuestionAnswer(CreateDto createDto, Long questionId);
    List<QuestionAnswerListResponse> getList();
    QuestionAnswerResponse getMainpage(Long questionId);

}
