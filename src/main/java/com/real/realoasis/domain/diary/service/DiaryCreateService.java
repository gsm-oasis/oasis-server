package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.request.DiaryCreateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiaryCreateService {
    void createDiary(DiaryCreateRequest createDairyRequest, List<MultipartFile> files) throws Exception;
}
