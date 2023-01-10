package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerMainpageService;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetQuestionAnswerMainpageServiceImpl implements GetQuestionAnswerMainpageService {
    private final QuestionAnswerFacade questionAnswerFacade;
    private final UserFacade userFacade;

    @Override
    public QuestionAnswerResponse getMainpage(Long questionId) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        String answer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, currentUser.getId());
        String coupleAnswer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, coupleUser.getId());

        return QuestionAnswerResponse.builder()
                .userName(currentUser.getNickname())
                .coupleName(coupleUser.getNickname())
                .answer(answer)
                .coupleAnswer(coupleAnswer)
                .build();
    }
}
