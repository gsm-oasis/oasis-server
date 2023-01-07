package com.real.realoasis.domain.diary.util;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.request.DiaryCreateRequest;
import com.real.realoasis.domain.user.entity.User;

public interface DiaryConverter {
    CreateDiaryDto toCreateDiaryDto(DiaryCreateRequest createDiaryRequest);

    Diary toEntity(CreateDiaryDto createDiaryDto, User user);
}
