package com.real.realoasis.domain.couple.util;

import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;

public interface CoupleConverter {
    MainPageDto toDto(User currentUser, User coupleUser, long datingDate, Question question);

    MainPageResponse toResponse(MainPageDto mainPageDto);

    EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest);
}
