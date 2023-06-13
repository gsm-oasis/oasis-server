package com.real.realoasis.domain.diary.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryRequest {
    private String title;
    private String content;
    private String mood;
    private String writer;
}
