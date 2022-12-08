package com.real.realoasis.domain.diary.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListDiaryPageResponse {
    private Long diaryId;
    private String content;
    private String mood;
    private String title;
    private String writer;
    private String createDate;
}
