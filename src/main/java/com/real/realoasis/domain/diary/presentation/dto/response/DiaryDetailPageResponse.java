package com.real.realoasis.domain.diary.presentation.dto.response;

import com.real.realoasis.domain.file.entity.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDetailPageResponse {
    private String title;
    private String content;
    private String mood;
    private String writer;
    private List<File> photoList;
}
