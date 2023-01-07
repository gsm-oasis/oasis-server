package com.real.realoasis.domain.diary.service;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.request.DiaryCreateRequest;
import com.real.realoasis.domain.diary.data.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListPageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Stream;


public interface DiaryService {
    void createDiary(CreateDiaryDto CreateDiaryDto, List<MultipartFile> files) throws Exception;
    void deleteDiary(Long diaryId);
    DiaryDetailPageResponse getDetailPage(Long diaryId);
    void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest, List<MultipartFile> multipartFileList) throws Exception;
    Stream<DiaryListPageResponse> getList();


}
