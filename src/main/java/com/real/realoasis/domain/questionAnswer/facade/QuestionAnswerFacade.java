package com.real.realoasis.domain.questionAnswer.facade;

import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.exception.QuestionNotFoundException;
import com.real.realoasis.domain.questionAnswer.repository.QuestionAnswerRepository;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class QuestionAnswerFacade {
    private final QuestionAnswerRepository questionRepository;

    @Transactional(rollbackFor = Exception.class)
    public QuestionAnswer findQuestionByQuestionId(Long questionId){
        return questionRepository.findQuestionById(questionId).orElseThrow(() -> new QuestionNotFoundException(ErrorCode.QUESTION_NOT_FOUND_EXCEPTION));
    }

    public void saveAnswer(QuestionAnswer question) {
        questionRepository.save(question);
    }
}
