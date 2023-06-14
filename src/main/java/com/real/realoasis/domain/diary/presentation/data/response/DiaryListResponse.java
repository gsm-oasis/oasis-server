package com.real.realoasis.domain.diary.presentation.data.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryListResponse {
    private final List<DiaryResponse> diaries;
}
