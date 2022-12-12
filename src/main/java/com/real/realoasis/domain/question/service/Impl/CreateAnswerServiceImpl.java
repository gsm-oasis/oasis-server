package com.real.realoasis.domain.question.service.Impl;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.question.facade.QuestionFacade;
import com.real.realoasis.domain.question.presentation.dto.request.QuestionAnswerRequest;
import com.real.realoasis.domain.question.service.CreateAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAnswerServiceImpl implements CreateAnswerService {
    private final QuestionFacade questionFacade;

    @Override
    public void createAnswer(QuestionAnswerRequest questionAnswerRequest, Long questionId) {
        Question question = questionFacade.findQuestionByQuestionId(questionId);

        question.updateAnswer(questionAnswerRequest.getAnswer());

        questionFacade.saveAnswer(question);
    }
}
