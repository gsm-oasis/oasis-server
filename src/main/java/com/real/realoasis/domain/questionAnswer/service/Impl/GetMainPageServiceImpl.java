package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.GetMainPageService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;

    @Override
    public QuestionAnswerResponse getMainpage(Long questionId) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        String answer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, currentUser.getId());
        String coupleAnswer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, coupleUser.getId());

        QuestionAnswerDto questionAnswerDto = questionAnswerConverter.toAnswerDto(currentUser, coupleUser, answer, coupleAnswer);
        return questionAnswerConverter.toResponse(questionAnswerDto);
    }
}
