package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DiaryService {
    void createDiary(CreateDiaryDto CreateDiaryDto, List<MultipartFile> files) throws Exception;
    void deleteDiary(Long diaryId);
    DiaryDetailResponse getDetail(Long diaryId);
    void editDiary(Long diaryId, EditDiaryDto editDiaryDto, List<MultipartFile> multipartFileList) throws Exception;
    DiaryListResponse getList();


}
