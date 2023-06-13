package com.real.realoasis.domain.diary.presentation.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditDiaryRequest {
    private String title;
    private String content;
    private String mood;
}
