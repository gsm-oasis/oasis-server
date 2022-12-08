package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.presentation.dto.request.QuestionTimeChangeRequest;
import com.real.realoasis.domain.user.service.QuestionTimeChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionTimeChangeServiceImpl implements QuestionTimeChangeService {
    private final UserFacade userFacade;

    @Override
    public void questionTimeChange(QuestionTimeChangeRequest questionTimeChangeRequest) {
        User currentUser = userFacade.currentUser();
        currentUser.updateQuestionTime(questionTimeChangeRequest.getQuestionTime());
        userFacade.saveUser(currentUser);
    }
}
