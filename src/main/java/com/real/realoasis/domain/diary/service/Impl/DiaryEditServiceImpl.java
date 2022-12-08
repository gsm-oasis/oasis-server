package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.service.DiaryEditService;
import com.real.realoasis.domain.file.entity.File;
import com.real.realoasis.domain.file.handler.FileHandler;
import com.real.realoasis.domain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryEditServiceImpl implements DiaryEditService {
    private final DiaryFacade diaryFacade;
    private final FileHandler fileHandler;
    private final FileRepository photoRepository;

    @Override
    public void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest, List<MultipartFile> files) throws Exception {
        // 수정할 일기 객체 찾기
        Diary editDiary = diaryFacade.findDiaryById(diaryId);

        List<File> photoList = fileHandler.parseFileInfo(files);
        if(!photoList.isEmpty()) {
            List<File> list = new ArrayList<>();
            for (File photo : photoList) {
                list.add(photoRepository.save(photo));
            }
            editDiary.updatePhoto(list);
        }
        editDiary.update(editDiaryRequest.getTitle(), editDiaryRequest.getContent(), editDiaryRequest.getMood());
        diaryFacade.saveDiary(editDiary);
    }
}
