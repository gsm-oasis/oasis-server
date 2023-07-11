package com.real.realoasis.domain.couple.presentation.data.dto;

import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Builder
public class MainPageDto {
    private final String nickname;
    private final String coupleNickname;
    private final int heartLevel;
    private final long datingDate;
    private final int severalHundredDays;
    private final String anniversaryName;
    private final int daysLeft;
    private final Long questionId;
    private final String content;
    private final List<DiaryDto> diaryListDtoList;
}
