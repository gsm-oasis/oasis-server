package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerListService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetQuestionAnswerListServiceImpl implements GetQuestionAnswerListService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;

    @Override
    public QuestionAnswerListResponse getList() {
        User currentUser = userFacade.currentUser();

        List<QuestionAnswer> list = questionAnswerFacade.findAllByUserId(currentUser.getId());
        List<QuestionAnswerListDto> questionAnswerDtoList = questionAnswerConverter.toListDto(list);
        return questionAnswerConverter.toListResponse(questionAnswerDtoList);
    }
}
