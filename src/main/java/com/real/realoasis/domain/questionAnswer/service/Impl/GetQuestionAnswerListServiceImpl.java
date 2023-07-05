package com.real.realoasis.domain.questionAnswer.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import com.real.realoasis.domain.questionAnswer.facade.QuestionAnswerFacade;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerListService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GetQuestionAnswerListServiceImpl implements GetQuestionAnswerListService {
    private final UserFacade userFacade;
    private final QuestionAnswerFacade questionAnswerFacade;
    private final QuestionAnswerConverter questionAnswerConverter;

    @Override
    public List<QuestionAnswerListDto> getList() {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        User coupleUser;
        if (couple.getUserA().equals(currentUser)) {
            coupleUser = couple.getUserB();
        } else
            coupleUser = couple.getUserA();

        List<QuestionAnswer> list = questionAnswerFacade.findAllByUserIdx(currentUser.getIdx());
        List<QuestionAnswer> coupleList = questionAnswerFacade.findAllByUserIdx(coupleUser.getIdx());
        List<QuestionAnswer> mergedList = Stream.of(list, coupleList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return questionAnswerConverter.toListDto(mergedList);
    }
}
