package com.real.realoasis.domain.user.presentation.dto.response;

import com.real.realoasis.domain.diary.data.response.DiaryListResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MainPageResponse {
    private String nickname;
    private String coupleNickname;
    private int heartLevel;
    private long datingDate;
    private int anniversary;
    private Long questionId;
    private String content;
    private List<DiaryListResponse> diaryListPageResponse;
}
