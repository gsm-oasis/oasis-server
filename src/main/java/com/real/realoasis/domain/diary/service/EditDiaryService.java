package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.EditDiaryDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EditDiaryService {
    void editDiary(Long diaryId, EditDiaryDto editDiaryDto, List<MultipartFile> multipartFileList) throws Exception;
}
