package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.controller.QuestionAnswerController;
import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.service.QuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    private final QuestionAnswerFacade questionAnswerFacade;
    private final UserFacade userFacade;
    private final QuestionAnswerConverter questionAnswerConverter;

    @Override
    public void createQuestionAnswer(CreateDto createDto, Long questionId) {
        User currentUser = userFacade.currentUser();
        Question question = questionAnswerFacade.findQuestionByQuestionId(questionId);
        QuestionAnswer questionAnswer = questionAnswerConverter.toEntity(createDto, question, currentUser);
        questionAnswerFacade.saveAnswer(questionAnswer);
    }

    @Override
    public Stream<QuestionAnswerListResponse> getList() {
        User currentUser = userFacade.currentUser();

        List<QuestionAnswerListResponse> list = new ArrayList<>();

        questionAnswerFacade.findAllByUserId(currentUser.getId()).forEach(questionAnswer -> {
            Long questionId = questionAnswer.getQuestion().getId();
            String content = questionAnswer.getQuestion().getContent();
            list.add(new QuestionAnswerListResponse(questionId, content));
        });
        return list.stream()
                .sorted(Comparator.comparing(QuestionAnswerListResponse::getQuestionId).reversed());
    }

    @Override
    public QuestionAnswerResponse getMainpage(Long questionId) {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        String answer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, currentUser.getId());
        String coupleAnswer = questionAnswerFacade.findQuestionAnswerByQuestionIdUserId(questionId, coupleUser.getId());

        return QuestionAnswerResponse.builder()
                .userName(currentUser.getNickname())
                .coupleName(coupleUser.getNickname())
                .answer(answer)
                .coupleAnswer(coupleAnswer)
                .build();
    }
}
