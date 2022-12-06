package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.real.realoasis.domain.diary.service.CreateDiaryService;
import com.real.realoasis.domain.photo.entity.Photo;
import com.real.realoasis.domain.photo.handler.FileHandler;
import com.real.realoasis.domain.photo.repository.PhotoRepository;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateDairyServiceImpl implements CreateDiaryService {
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;
    private final PhotoRepository photoRepository;
    private final FileHandler fileHandler;
    @Override
    public void createDiary(CreateDiaryRequest createDairyRequest, List<MultipartFile> files) throws Exception{

        User user = userFacade.currentUser();
        // 파일 처리를 위한 Diary 객체 생성
        Diary diary = createDairyRequest.toEntity(user);
        List<Photo> photoList = fileHandler.parseFileInfo(files);
        //파일이 존재할 때만 처리
        if(!photoList.isEmpty()) {
            List<Photo> list = new ArrayList<>();
            for(Photo photo : photoList) {
                // 파일을 DB에 저장
             list.add(photoRepository.save(photo));
            }
            diary.updatePhoto(list);
        }
        diaryFacade.saveDairy(diary);
    }
}
