package com.real.realoasis.domain.questionAnswer.facade;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.question.repository.QuestionRepository;
import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import com.real.realoasis.domain.question.exception.QuestionNotFoundException;
import com.real.realoasis.domain.questionAnswer.repository.QuestionAnswerRepository;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
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
    private final UserFacade userFacade;

    public Question findQuestionByQuestionId(Long questionId){
       return questionRepository.findQuestionById(questionId).orElseThrow(() -> new QuestionNotFoundException(ErrorCode.QUESTION_NOT_FOUND_EXCEPTION));
    }

    public String findQuestionAnswerByQuestionAndUser(Long questionId, String userId){
        Question question = questionRepository.findQuestionById(questionId).orElseThrow(() -> new QuestionNotFoundException(ErrorCode.QUESTION_NOT_FOUND_EXCEPTION));
        User user = userFacade.findUserById(userId);

        QuestionAnswer questionAnswer = questionAnswerRepository.findQuestionAnswersByQuestionAndUser(question, user);
        if(questionAnswer == null){
            return  "";
        } else {
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
