package com.real.realoasis.domain.diary.presentation.dto.request;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryRequest {
    private String title;
    private String content;
    private String mood;
    private String writer;

    public Diary toEntity(User user){
        return Diary.builder()
                .title(title)
                .content(content)
                .mood(mood)
                .writer(writer)
                .user(user)
                .build();
    }
}
