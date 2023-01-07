package com.real.realoasis.domain.diary.data.request;

import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryCreateRequest {
    private String title;
    private String content;
    private String mood;
    private String writer;
}
