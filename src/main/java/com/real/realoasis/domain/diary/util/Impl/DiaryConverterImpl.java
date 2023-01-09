package com.real.realoasis.domain.diary.util.Impl;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.DiaryDetailPageDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DiaryConverterImpl implements DiaryConverter {

    @Override
    public CreateDiaryDto toCreateDiaryDto(CreateDiaryRequest createDiaryRequest) {
        return CreateDiaryDto.builder()
                .content(createDiaryRequest.getContent())
                .mood(createDiaryRequest.getMood())
                .title(createDiaryRequest.getTitle())
                .writer(createDiaryRequest.getWriter())
                .build();
    }

    @Override
    public Diary toEntity(CreateDiaryDto createDiaryDto, User user) {
        return Diary.builder()
                .content(createDiaryDto.getContent())
                .mood(createDiaryDto.getMood())
                .title(createDiaryDto.getTitle())
                .writer(createDiaryDto.getWriter())
                .user(user)
                .build();
    }

    @Override
    public EditDiaryDto toEditDiaryDto(EditDiaryRequest editDiaryRequest) {
        return EditDiaryDto.builder()
                .title(editDiaryRequest.getTitle())
                .content(editDiaryRequest.getContent())
                .mood(editDiaryRequest.getMood())
                .build();
    }

    @Override
    public DiaryDetailPageDto toDetailPageDto(String title, String content, String mood, List<Image> images, String createDate) {
        return DiaryDetailPageDto.builder()
                .title(title)
                .content(content)
                .mood(mood)
                .imgs(images)
                .createDate(createDate)
                .build();
    }

    @Override
    public DiaryDetailPageResponse toDetailPageResponse(DiaryDetailPageDto diaryDetailPageDto) {
        return DiaryDetailPageResponse.builder()
                .title(diaryDetailPageDto.getTitle())
                .content(diaryDetailPageDto.getContent())
                .mood(diaryDetailPageDto.getMood())
                .imgs(diaryDetailPageDto.getImgs())
                .createDate(diaryDetailPageDto.getCreateDate())
                .build();
    }
}
