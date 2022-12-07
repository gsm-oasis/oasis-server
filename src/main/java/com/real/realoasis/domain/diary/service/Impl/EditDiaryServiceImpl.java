package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.EditDiaryRequest;
import com.real.realoasis.domain.diary.service.EditDiaryService;
import com.real.realoasis.domain.photo.entity.Photo;
import com.real.realoasis.domain.photo.handler.FileHandler;
import com.real.realoasis.domain.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditDiaryServiceImpl implements EditDiaryService {
    private final DiaryFacade diaryFacade;
    private final FileHandler fileHandler;
    private final PhotoRepository photoRepository;

    @Override
    public void editDiary(Long diaryId, EditDiaryRequest editDiaryRequest, List<MultipartFile> files) throws Exception {
        // 수정할 일기 객체 찾기
        Diary editDiary = diaryFacade.findDiaryById(diaryId);

        List<Photo> photoList = fileHandler.parseFileInfo(files);
        if(!photoList.isEmpty()) {
            List<Photo> list = new ArrayList<>();
            for (Photo photo : photoList) {
                list.add(photoRepository.save(photo));
            }
            editDiary.updatePhoto(list);
        }
        editDiary.update(editDiaryRequest.getTitle(), editDiaryRequest.getContent(), editDiaryRequest.getMood());
        diaryFacade.saveDairy(editDiary);
    }
}
