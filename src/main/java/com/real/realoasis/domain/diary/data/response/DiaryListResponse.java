package com.real.realoasis.domain.diary.data.response;

import com.real.realoasis.domain.diary.data.dto.DiaryListDto;
import lombok.*;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryListResponse {
    private final List<DiaryListDto> diaries;
}
