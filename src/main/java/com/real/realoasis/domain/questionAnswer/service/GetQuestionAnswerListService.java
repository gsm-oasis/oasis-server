package com.real.realoasis.domain.questionAnswer.service;

import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import java.util.List;

public interface GetQuestionAnswerListService {
    List<QuestionAnswerListDto> getList();
}
