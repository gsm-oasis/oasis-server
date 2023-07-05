package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.domain.repository.QuestionAnswerRepository;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateQuestionAnswerServiceImpl implements CreateQuestionAnswerService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;
    private final QuestionAnswerRepository questionAnswerRepository;

    @Override
    @Transactional
    public void createQuestionAnswer(CreateDto createDto, Long questionId) {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        Question question = questionAnswerFacade.findQuestionByQuestionId(questionId);
        QuestionAnswer questionAnswer;
        if(questionAnswerRepository.findByQuestionIdxAndCouple(questionId, couple) == null)
            questionAnswer = questionAnswerConverter.toEntity(createDto, question, couple, currentUser);
        else
            questionAnswer = questionAnswerRepository.findByQuestionIdxAndCouple(questionId, couple);

        if(currentUser.equals(couple.getUserA()))
            questionAnswer.writeA(createDto.getAnswer());
        else
            questionAnswer.writeB(createDto.getAnswer());
        couple.getHeart().updateLevelBar();
    }
}
