package com.real.realoasis.domain.user.data.dto;

import com.real.realoasis.domain.diary.data.response.DiaryListResponse;
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
    private final int anniversary;
    private final Long questionId;
    private final String content;
    private final DiaryListResponse diaryListPageResponse;
}
