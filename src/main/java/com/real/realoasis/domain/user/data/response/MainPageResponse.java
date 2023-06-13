package com.real.realoasis.domain.user.data.response;

import com.real.realoasis.domain.diary.presentation.dto.DiaryListDto;
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
    private final int anniversary;
    private final Long questionId;
    private final String content;
    private final List<DiaryListDto> diaryListPageResponse;
}
