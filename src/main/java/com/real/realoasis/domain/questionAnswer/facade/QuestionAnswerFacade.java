package com.real.realoasis.domain.questionAnswer.facade;

import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.question.domain.repository.QuestionRepository;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.question.exception.QuestionNotFoundException;
import com.real.realoasis.domain.questionAnswer.domain.repository.QuestionAnswerRepository;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class QuestionAnswerFacade {
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionRepository questionRepository;

    public Question findQuestionByQuestionId(Long questionId){
       return questionRepository.findQuestionByIdx(questionId).orElseThrow(() -> new QuestionNotFoundException(ErrorCode.QUESTION_NOT_FOUND_EXCEPTION));
    }

    public String findQuestionAnswerByQuestionIdxUserIdx(Long questionId, Long userId){
        QuestionAnswer questionAnswer = questionAnswerRepository.findQuestionAnswerByQuestionIdxAndUserIdx(questionId, userId);
        if(questionAnswer == null){
            return "";
        }else {
            return questionAnswer.getAnswer();
        }
    }
    public void saveAnswer(QuestionAnswer questionAnswer) {
        questionAnswerRepository.save(questionAnswer);
    }

    public List<QuestionAnswer> findAllByUserId(String userId) {
        return questionAnswerRepository.findAllByUserId(userId);
    }
}
