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
    @Override
    public void createDiary(DiaryCreateRequest createDairyRequest){
        User user = userFacade.currentUser();
        Diary diary = createDairyRequest.toEntity(user);
        diaryFacade.saveDiary(diary);
    }
}
