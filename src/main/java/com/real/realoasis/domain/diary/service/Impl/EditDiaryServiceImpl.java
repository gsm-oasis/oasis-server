package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.service.EditDiaryService;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditDiaryServiceImpl implements EditDiaryService {
    private final DiaryFacade diaryFacade;
    private final ImageService imageService;

    @Override
    public void editDiary(Long diaryId, EditDiaryDto editDiaryDto, List<MultipartFile> files) throws Exception {
        // 수정할 일기 객체 찾기
        Diary editDiary = diaryFacade.findDiaryById(diaryId);
        List<String> imgUrlList = imageService.upload(files);

        if(!imgUrlList.isEmpty()) {
            List<Image> imageList = new ArrayList<>();
            for(String imgUrl : imgUrlList) {
                Image image = new Image(imgUrl, editDiary);
                imageList.add(image);
            }
        }
        editDiary.update(editDiaryDto.getTitle(), editDiaryDto.getContent(), editDiaryDto.getMood());
        diaryFacade.saveDiary(editDiary);
    }
}
