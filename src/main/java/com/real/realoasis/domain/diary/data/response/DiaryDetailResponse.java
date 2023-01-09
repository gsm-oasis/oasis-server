package com.real.realoasis.domain.diary.data.response;

import com.real.realoasis.domain.image.data.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDetailResponse {
    private String title;
    private String content;
    private String mood;
    private List<Image> imgs;
    private String createDate;
}
