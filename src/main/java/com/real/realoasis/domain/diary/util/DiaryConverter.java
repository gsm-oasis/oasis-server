package com.real.realoasis.domain.diary.util;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.DiaryDetailPageDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.user.entity.User;

import java.util.List;

public interface DiaryConverter {
    CreateDiaryDto toCreateDiaryDto(CreateDiaryRequest createDiaryRequest);

    Diary toEntity(CreateDiaryDto createDiaryDto, User user);

    EditDiaryDto toEditDiaryDto(EditDiaryRequest editDiaryRequest);

    DiaryDetailPageDto toDetailPageDto(String title, String content, String mood, List<Image> images, String createDate);

    DiaryDetailPageResponse toDetailPageResponse(DiaryDetailPageDto diaryDetailPageDto);
}
