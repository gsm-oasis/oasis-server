package com.real.realoasis.domain.couple.util;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryResponse;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;

import java.util.List;

public interface CoupleConverter {
    MainPageDto toDto(Couple couple, Question question, long daysLeft);
    MainPageResponse toResponse(MainPageDto mainPageDto, List<DiaryResponse> diaryResponseList);

    EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest);
}
