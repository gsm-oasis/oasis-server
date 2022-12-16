package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerListService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class GetQuestionAnswerListServiceImpl implements GetQuestionAnswerListService {
    private final QuestionAnswerFacade questionAnswerFacade;
    private final UserFacade userFacade;

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
}
