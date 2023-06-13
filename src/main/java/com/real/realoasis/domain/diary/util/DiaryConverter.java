package com.real.realoasis.domain.diary.util;

import com.real.realoasis.domain.diary.presentation.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryListDto;
import com.real.realoasis.domain.diary.presentation.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.presentation.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.user.domain.entity.User;

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
