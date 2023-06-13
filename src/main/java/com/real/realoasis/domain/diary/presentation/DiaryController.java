package com.real.realoasis.domain.diary.presentation;

import com.real.realoasis.domain.diary.presentation.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.presentation.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.presentation.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.service.*;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {
    private final CreateDiaryService createDiaryService;
    private final DeleteDiaryService deleteDiaryService;
    private final EditDiaryService editDiaryService;
    private final GetDiaryDetailService getDiaryDetailService;
    private final GetDiaryListService getDiaryListService;
    private final DiaryConverter diaryConverter;

    //일기 생성
    @PostMapping("/create")
    public ResponseEntity<Void> createDiary(
            @RequestPart(value = "file", required = false)List<MultipartFile> files,
            @RequestPart(value = "req") CreateDiaryRequest createDiaryRequest) throws Exception {
        CreateDiaryDto createDiaryDto = diaryConverter.toCreateDiaryDto(createDiaryRequest);
        createDiaryService.create(createDiaryDto, files);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //일기 수정
    @PatchMapping("/edit/{diaryId}")
    public ResponseEntity<Void> editDiary(
            @PathVariable Long diaryId,
            @RequestPart(value = "file", required = false)List<MultipartFile> files,
            @RequestPart(value = "req") EditDiaryRequest editDiaryRequest) throws Exception {
        EditDiaryDto editDiaryDto = diaryConverter.toEditDiaryDto(editDiaryRequest);
        editDiaryService.editDiary(diaryId, editDiaryDto, files);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //일기디테일 페이지
    @GetMapping("/detail/{diaryId}")
    public ResponseEntity<DiaryDetailResponse> getDetailPage(@PathVariable Long diaryId){
        DiaryDetailResponse diaryDetailPageResponse = getDiaryDetailService.get(diaryId);
        return new ResponseEntity<>(diaryDetailPageResponse, HttpStatus.OK);
    }

    //일기 삭제
    @DeleteMapping("/delete/{diaryId}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long diaryId){
        deleteDiaryService.delete(diaryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //일기 리스트
    @GetMapping("/list")
    public ResponseEntity<DiaryListResponse> getList(){
        DiaryListResponse diaryListPageResponse = getDiaryListService.getList();
        return new ResponseEntity<>(diaryListPageResponse,HttpStatus.OK);
    }
}
