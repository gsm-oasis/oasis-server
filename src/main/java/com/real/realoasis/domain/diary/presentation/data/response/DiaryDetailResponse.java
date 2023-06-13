package com.real.realoasis.domain.diary.presentation.data.response;

import com.real.realoasis.domain.image.domain.entity.Image;
import lombok.*;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryDetailResponse {
    private final String title;
    private final String content;
    private final String mood;
    private final List<Image> imgs;
    private final String createDate;
}
