package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.domain.repository.QuestionAnswerRepository;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.GetMainPageService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final QuestionAnswerConverter questionAnswerConverter;
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionAnswerFacade questionAnswerFacade;

    @Override
    public QuestionAnswerDto getMainpage(Long questionId) {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        Question question = questionAnswerFacade.findQuestionByQuestionId(questionId);
        QuestionAnswer questionAnswer = questionAnswerRepository.findByQuestionIdxAndCouple(questionId, couple);
        User coupleUser;
        String answer;
        String coupleAnswer;

        if(questionAnswer == null) {
            questionAnswer = new QuestionAnswer(
                    "",
                    "",
                    question,
                    couple
            );
            questionAnswerRepository.save(questionAnswer);
        }

        if(couple.getUserA().equals(currentUser)) {
            coupleUser = couple.getUserB();
            answer = questionAnswer.getAnswerA();
            coupleAnswer = questionAnswer.getAnswerB();
        }
        else {
            coupleUser = couple.getUserA();
            answer = questionAnswer.getAnswerB();
            coupleAnswer = questionAnswer.getAnswerA();
        }

        return questionAnswerConverter.toAnswerDto(currentUser, coupleUser, answer, coupleAnswer);
    }
}
