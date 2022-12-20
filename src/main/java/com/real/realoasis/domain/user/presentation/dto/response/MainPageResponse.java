package com.real.realoasis.domain.user.presentation.dto.response;

import com.real.realoasis.domain.diary.presentation.dto.response.DiaryListPageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Period;
import java.util.stream.Stream;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MainPageResponse {
    private int heartLevel;
    private long datingDate;
    private Long questionId;
    private String content;
    private Stream<DiaryListPageResponse> diaryListPageResponse;
}
