package com.real.realoasis.domain.diary.controller;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.data.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListPageResponse;
import com.real.realoasis.domain.diary.service.*;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {
    private final DiaryService diaryService;
    private final DiaryConverter diaryConverter;

    //일기 생성
    @PostMapping("/create")
    public ResponseEntity<Void> createDiary(
            @RequestPart(value = "file", required = false)List<MultipartFile> files,
            @RequestPart(value = "req") CreateDiaryRequest createDiaryRequest) throws Exception {
        CreateDiaryDto createDiaryDto = diaryConverter.toCreateDiaryDto(createDiaryRequest);
        diaryService.createDiary(createDiaryDto, files);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //일기 수정
    @PatchMapping("/edit/{diaryId}")
    public ResponseEntity<Void> editDiary(
            @PathVariable Long diaryId,
            @RequestPart(value = "file", required = false)List<MultipartFile> files,
            @RequestPart(value = "req") EditDiaryRequest editDiaryRequest) throws Exception {
        EditDiaryDto editDiaryDto = diaryConverter.toEditDiaryDto(editDiaryRequest);
        diaryService.editDiary(diaryId, editDiaryDto, files);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //일기디테일 페이지
    @GetMapping("/detail/{diaryId}")
    public ResponseEntity<DiaryDetailPageResponse> getDetailPage(@PathVariable Long diaryId){
        DiaryDetailPageResponse diaryDetailPageResponse = diaryService.getDetailPage(diaryId);
        return new ResponseEntity<>(diaryDetailPageResponse, HttpStatus.OK);
    }

    //일기 삭제
    @DeleteMapping("/delete/{diaryId}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long diaryId){
        diaryService.deleteDiary(diaryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //일기 리스트
    @GetMapping("/list")
    public ResponseEntity<Stream<DiaryListPageResponse>> getList(){
        return new ResponseEntity<>(diaryService.getList(), HttpStatus.OK);
    }

}
