package com.real.realoasis.domain.diary.presentation;

import com.real.realoasis.domain.diary.presentation.dto.request.DiaryCreateRequest;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.presentation.dto.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.presentation.dto.response.DiaryListPageResponse;
import com.real.realoasis.domain.diary.service.*;
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
    private final DiaryCreateService createDiaryService;
    private final DiaryEditService editDiaryService;
    private final DiaryDetailPageService detailDiaryPageService;
    private final DiaryDeleteService deleteDiaryService;
    private final DiaryListPageService listDiaryPageService;

    //일기 생성
    @PostMapping("/create")
    public ResponseEntity<Void> createDiary(@RequestBody DiaryCreateRequest createDiaryRequest) throws Exception {
        createDiaryService.createDiary(createDiaryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //일기 수정
    @PatchMapping("/edit/{diaryId}")
    public ResponseEntity<Void> editDiary(
            @PathVariable Long diaryId,
            @RequestPart(value = "req") DiaryEditRequest editDiaryRequest) {
        editDiaryService.editDiary(diaryId, editDiaryRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //일기디테일 페이지
    @GetMapping("/detail/{diaryId}")
    public ResponseEntity<DiaryDetailPageResponse> getDetailPage(@PathVariable Long diaryId){
        return new ResponseEntity<>(detailDiaryPageService.getDetailPage(diaryId), HttpStatus.OK);
    }

    //일기 삭제
    @DeleteMapping("/delete/{diaryId}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long diaryId){
        deleteDiaryService.deleteDiary(diaryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //일기 리스트
    @GetMapping("/list")
    public ResponseEntity<Stream<DiaryListPageResponse>> getList(){
        return new ResponseEntity<>(listDiaryPageService.getList(), HttpStatus.OK);
    }

}
