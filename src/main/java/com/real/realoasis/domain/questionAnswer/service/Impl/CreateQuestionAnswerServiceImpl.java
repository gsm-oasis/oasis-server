package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateQuestionAnswerServiceImpl implements CreateQuestionAnswerService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;

    @Override
    public void createQuestionAnswer(CreateDto createDto, Long questionId) {
        User currentUser = userFacade.currentUser();
        Question question = questionAnswerFacade.findQuestionByQuestionId(questionId);
        QuestionAnswer questionAnswer = questionAnswerConverter.toEntity(createDto, question, currentUser);
        questionAnswerFacade.saveAnswer(questionAnswer);
    }
}
