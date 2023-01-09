package com.real.realoasis.domain.diary.util;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.data.request.EditDiaryRequest;
import com.real.realoasis.domain.user.entity.User;

public interface DiaryConverter {
    CreateDiaryDto toCreateDiaryDto(CreateDiaryRequest createDiaryRequest);

    Diary toEntity(CreateDiaryDto createDiaryDto, User user);

    EditDiaryDto toEditDiaryDto(EditDiaryRequest editDiaryRequest);
}
