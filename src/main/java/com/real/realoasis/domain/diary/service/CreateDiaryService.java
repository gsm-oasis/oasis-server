package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.presentation.dto.CreateDiaryDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreateDiaryService {
    void create(CreateDiaryDto CreateDiaryDto, List<MultipartFile> files) throws Exception;
}
