package com.real.realoasis.domain.couple.util;

import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.couple.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.couple.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.couple.presentation.data.response.MainPageResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryResponse;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.user.domain.entity.User;

import java.util.List;

public interface CoupleConverter {
    MainPageDto toDto(Couple couple, Question question, int daysLeft, User user, CoupleAnniversaryDate coupleAnniversaryDate);
    MainPageResponse toResponse(MainPageDto mainPageDto, List<DiaryResponse> diaryResponseList);

    EnterDto toEnterDto(DatingDateEnterRequest datingDateEnterRequest);
}
