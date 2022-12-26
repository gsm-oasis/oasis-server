package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryCreateRequest;
import com.real.realoasis.domain.diary.service.DiaryCreateService;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.image.service.ImageService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryCreateServiceImpl implements DiaryCreateService {
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;
    private final ImageService imageService;
    @Override
    public void createDiary(DiaryCreateRequest createDairyRequest, List<MultipartFile> files) throws Exception{

        User user = userFacade.currentUser();
        // 파일 처리를 위한 Diary 객체 생성
        Diary diary = createDairyRequest.toEntity(user);
        List<String> imgUrlList = imageService.upload(files);
        //파일이 존재할 때만 처리
        if(!imgUrlList.isEmpty()) {
            List<Image> list = new ArrayList<>();
            for(String imgUrl : imgUrlList) {
                Image image = new Image(imgUrl);
                list.add(image);
            }
            diary.updateImages(list);
        }
        diaryFacade.saveDiary(diary);
    }
}
