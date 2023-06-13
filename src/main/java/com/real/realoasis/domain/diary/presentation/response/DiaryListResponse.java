package com.real.realoasis.domain.diary.presentation.response;

import com.real.realoasis.domain.diary.presentation.dto.DiaryListDto;
import lombok.*;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryListResponse {
    private final List<DiaryListDto> diaries;
}
