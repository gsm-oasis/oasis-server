package com.real.realoasis.domain.diary.service;


import com.real.realoasis.domain.diary.presentation.dto.request.EditDiaryRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EditDiaryService {
    void editDiary(Long diaryId, EditDiaryRequest editDiaryRequest, List<MultipartFile> multipartFileList) throws Exception;
}
