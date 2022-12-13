package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerRequest;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateQuestionAnswerServiceImpl implements CreateQuestionAnswerService {
    private final QuestionAnswerFacade questionAnswerFacade;
    private final UserFacade userFacade;

    @Override
    public void createQuestionAnswer(QuestionAnswerRequest questionAnswerRequest, Long questionId) {
        User currentUser = userFacade.currentUser();
        QuestionAnswer question = questionAnswerFacade.findQuestionByQuestionId(questionId);

        question.updateAnswer(questionAnswerRequest.getAnswer());

        questionAnswerFacade.saveAnswer(question);
    }
}
