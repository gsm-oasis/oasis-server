package com.real.realoasis.domain.diary.util;

import com.real.realoasis.domain.diary.presentation.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.presentation.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.dto.DiaryListDto;
import com.real.realoasis.domain.diary.presentation.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.presentation.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.presentation.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.presentation.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.response.DiaryListResponse;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.user.data.entity.User;

import java.util.List;

public interface DiaryConverter {
    CreateDiaryDto toCreateDiaryDto(CreateDiaryRequest createDiaryRequest);

    Diary toEntity(CreateDiaryDto createDiaryDto, User user);

    EditDiaryDto toEditDiaryDto(EditDiaryRequest editDiaryRequest);

    DiaryDetailDto toDetailDto(String title, String content, String mood, List<Image> images, String createDate);

    DiaryDetailResponse toDetailResponse(DiaryDetailDto diaryDetailPageDto);

    List<DiaryListDto> toListDto(List<Diary> mergedList);

    DiaryListResponse toListResponse(List<DiaryListDto> diaryListPageDto);
}
