package com.real.realoasis.domain.diary.service;


import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiaryEditService {
    void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest, List<MultipartFile> multipartFileList) throws Exception;
}
