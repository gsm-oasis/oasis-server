package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.service.CreateDiaryService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.image.domain.repository.ImageRepository;
import com.real.realoasis.domain.image.service.ImageService;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateDiaryServiceImpl implements CreateDiaryService {
    private final UserFacade userFacade;
    private final DiaryConverter diaryConverter;
    private final ImageService imageService;
    private final DiaryFacade diaryFacade;
    private final ImageRepository imageRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(CreateDiaryDto createDiaryDto, List<MultipartFile> files) throws Exception{
        User user = userFacade.currentUser();
        Heart heart = user.getCouple().getHeart();
        // 파일 처리를 위한 Diary 객체 생성
        Diary diary = diaryConverter.toEntity(createDiaryDto, user);
        List<String> imgUrlList = imageService.upload(files);
        //파일이 존재할 때만 처리
        if(!imgUrlList.isEmpty()) {
            for(String imgUrl : imgUrlList) {
                Image image = new Image(imgUrl, diary);
                imageRepository.save(image);
            }
        }
        diaryFacade.saveDiary(diary);
        heart.updateLevelBar();
    }
}
