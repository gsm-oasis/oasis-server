package com.real.realoasis.domain.couple.presentation.data.response;

import com.real.realoasis.domain.diary.presentation.data.response.DiaryResponse;
import lombok.*;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class MainPageResponse {
    private final String nickname;
    private final String coupleNickname;
    private final int heartLevel;
    private final long datingDate;
    private final int severalHundredDays;
    private final int daysLeft;
    private final String anniversaryName;
    private final Long questionId;
    private final String content;
    private final List<DiaryResponse> diaries;
}
