package com.real.realoasis.domain.diary.data.response;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class DiaryListResponse {
    private final Long diaryId;
    private final String content;
    private final String title;
    private final String writer;
    private final String createDate;
}
