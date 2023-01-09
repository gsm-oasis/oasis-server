package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListPageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DiaryService {
    void createDiary(CreateDiaryDto CreateDiaryDto, List<MultipartFile> files) throws Exception;
    void deleteDiary(Long diaryId);
    DiaryDetailPageResponse getDetailPage(Long diaryId);
    void editDiary(Long diaryId, EditDiaryDto editDiaryDto, List<MultipartFile> multipartFileList) throws Exception;
    List<DiaryListPageResponse> getList();


}
