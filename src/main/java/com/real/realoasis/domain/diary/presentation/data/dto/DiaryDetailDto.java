package com.real.realoasis.domain.diary.presentation.data.dto;

import com.real.realoasis.domain.image.domain.entity.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Builder
public class DiaryDetailDto {
    private final String title;
    private final String content;
    private final String mood;
    private final List<Image> imgs;
    private final String createDate;
}
