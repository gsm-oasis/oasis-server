package com.real.realoasis.domain.user.presentation.data.response;

import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
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
    private final long daysLeft;
    private final int anniversary;
    private final Long questionId;
    private final String content;
    private final List<DiaryResponse> diaries;
}
