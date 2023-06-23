package com.real.realoasis.domain.diary.util.Impl;

import com.real.realoasis.domain.diary.presentation.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDto;
import com.real.realoasis.domain.diary.presentation.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.presentation.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryResponse;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.user.domain.entity.User;
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
                .build();
    }

    @Override
    public Diary toEntity(CreateDiaryDto createDiaryDto, User user) {
        return Diary.builder()
                .content(createDiaryDto.getContent())
                .mood(createDiaryDto.getMood())
                .title(createDiaryDto.getTitle())
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
    public List<DiaryDto> toDto(List<Diary> mergedList, User user) {
        return mergedList.stream().map(diary ->
                new DiaryDto(
                        diary.getIdx(),
                        diary.getContent(),
                        diary.getTitle(),
                        user.getNickname(),
                        diary.getCreateDate()
                        )
        ).sorted(Comparator.comparing(DiaryDto::getDiaryId).reversed()).collect(Collectors.toList());
    }

    @Override
    public DiaryListResponse toListResponse(List<DiaryResponse> diaryListPageDto) {
        return DiaryListResponse.builder()
                .diaries(diaryListPageDto)
                .build();
    }

    @Override
    public DiaryResponse toResponse(DiaryDto diaryDto) {
        return DiaryResponse.builder()
                .diaryId(diaryDto.getDiaryId())
                .content(diaryDto.getContent())
                .title(diaryDto.getTitle())
                .writer(diaryDto.getWriter())
                .createDate(diaryDto.getCreateDate())
                .build();
    }
}
