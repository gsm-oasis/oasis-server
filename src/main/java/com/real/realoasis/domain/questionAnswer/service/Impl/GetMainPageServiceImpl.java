package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.couple.exception.CoupleNotFoundException;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.GetMainPageService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetMainPageServiceImpl implements GetMainPageService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;
    private final CoupleRepository coupleRepository;

    @Override
    public QuestionAnswerResponse getMainpage(Long questionId) {
        User currentUser = userFacade.currentUser();
        Couple foundCouple;
        User coupleUser = null;
        if (coupleRepository.existsByUserA(currentUser)) {
            foundCouple = coupleRepository.findByUserA(currentUser);
            coupleUser = foundCouple.getUserB();
        } else if (coupleRepository.existsByUserB(currentUser)) {
            foundCouple = coupleRepository.findByUserB(currentUser);
            coupleUser = foundCouple.getUserA();
        }

        String answer = questionAnswerFacade.findQuestionAnswerByQuestionIdxUserIdx(questionId, currentUser.getIdx());
        String coupleAnswer = questionAnswerFacade.findQuestionAnswerByQuestionIdxUserIdx(questionId, Objects.requireNonNull(coupleUser).getIdx());

        QuestionAnswerDto questionAnswerDto = questionAnswerConverter.toAnswerDto(currentUser, coupleUser, answer, coupleAnswer);
        return questionAnswerConverter.toResponse(questionAnswerDto);
    }
}
