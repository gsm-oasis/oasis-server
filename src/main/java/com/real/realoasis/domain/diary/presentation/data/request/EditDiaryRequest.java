package com.real.realoasis.domain.diary.presentation.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditDiaryRequest {
    @Size(min = 2, max = 12)
    private String title;
    @Size(min = 2)
    private String content;
    private String mood;
}
