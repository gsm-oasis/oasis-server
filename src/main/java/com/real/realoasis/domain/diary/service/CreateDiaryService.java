package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.request.CreateDiaryRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreateDiaryService {
    void createDiary(CreateDiaryRequest createDairyRequest, List<MultipartFile> files) throws Exception;
}
