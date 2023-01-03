package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerMainpageService;
import com.real.realoasis.domain.user.entity.User;
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

        Question question = questionAnswerFacade.findQuestionByQuestionId(questionId);

        String answer1 = questionAnswerFacade.findQuestionAnswerByQuestionIdAndUserId(questionId, currentUser.getId());
        String answer2 = questionAnswerFacade.findQuestionAnswerByQuestionIdAndUserId(questionId, coupleUser.getId());

        return QuestionAnswerResponse.builder()
                .content(question.getContent())
                .userName(currentUser.getNickname())
                .coupleName(coupleUser.getNickname())
                .answer(answer1)
                .coupleAnswer(answer2)
                .build();
    }
}
