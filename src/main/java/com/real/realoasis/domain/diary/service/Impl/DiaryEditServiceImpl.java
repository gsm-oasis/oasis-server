package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.service.DiaryEditService;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryEditServiceImpl implements DiaryEditService {
    private final DiaryFacade diaryFacade;
    private final ImageService imageService;

    @Override
    public void editDiary(Long diaryId, DiaryEditRequest editDiaryRequest, List<MultipartFile> files) throws Exception {
        // 수정할 일기 객체 찾기
        Diary editDiary = diaryFacade.findDiaryById(diaryId);
        List<String> imgUrlList = imageService.upload(files);

        if(!imgUrlList.isEmpty()) {
            List<Image> list = new ArrayList<>();
            for(String imgUrl : imgUrlList) {
                Image image = new Image(imgUrl);
                list.add(image);
            }
            editDiary.updateImages(list);
        }
        editDiary.update(editDiaryRequest.getTitle(), editDiaryRequest.getContent(), editDiaryRequest.getMood());
        diaryFacade.saveDiary(editDiary);
    }
}
