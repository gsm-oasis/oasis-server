package com.real.realoasis.domain.question.facade;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.question.exception.QuestionNotFoundException;
import com.real.realoasis.domain.question.repository.QuestionRepository;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class QuestionFacade {
    private final QuestionRepository questionRepository;

    @Transactional(rollbackFor = Exception.class)
    public Question findQuestionByQuestionId(Long questionId){
        return questionRepository.findQuestionById(questionId).orElseThrow(() -> new QuestionNotFoundException(ErrorCode.QUESTION_NOT_FOUND_EXCEPTION));
    }

    public void saveAnswer(Question question) {
        questionRepository.save(question);
    }
}
