package com.real.realoasis.domain.diary.util.Impl;

import com.real.realoasis.domain.diary.presentation.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryListDto;
import com.real.realoasis.domain.diary.presentation.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.presentation.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.user.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public DiaryDetailDto toDetailDto(String title, String content, String mood, List<Image> images, String createDate) {
        return DiaryDetailDto.builder()
                .title(title)
                .content(content)
                .mood(mood)
                .imgs(images)
                .createDate(createDate)
                .build();
    }

    @Override
    public DiaryDetailResponse toDetailResponse(DiaryDetailDto diaryDetailPageDto) {
        return DiaryDetailResponse.builder()
                .title(diaryDetailPageDto.getTitle())
                .content(diaryDetailPageDto.getContent())
                .mood(diaryDetailPageDto.getMood())
                .imgs(diaryDetailPageDto.getImgs())
                .createDate(diaryDetailPageDto.getCreateDate())
                .build();
    }

    @Override
    public List<DiaryListDto> toListDto(List<Diary> mergedList) {
        return mergedList.stream().map(diary ->
                new DiaryListDto(
                        diary.getId(),
                        diary.getContent(),
                        diary.getTitle(),
                        diary.getWriter(),
                        diary.getCreateDate()
                        )
        ).sorted(Comparator.comparing(DiaryListDto::getDiaryId).reversed()).collect(Collectors.toList());
    }

    @Override
    public DiaryListResponse toListResponse(List<DiaryListDto> diaryListPageDto) {
        return DiaryListResponse.builder()
                .diaries(diaryListPageDto)
                .build();
    }
}
