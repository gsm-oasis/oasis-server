package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.request.DiaryCreateRequest;
import com.real.realoasis.domain.diary.service.DiaryCreateService;
import com.real.realoasis.domain.file.entity.File;
import com.real.realoasis.domain.file.handler.FileHandler;
import com.real.realoasis.domain.file.repository.FileRepository;
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
    private final FileRepository photoRepository;
    private final FileHandler fileHandler;
    @Override
    public void createDiary(DiaryCreateRequest createDairyRequest, List<MultipartFile> files) throws Exception{

        User user = userFacade.currentUser();
        // 파일 처리를 위한 Diary 객체 생성
        Diary diary = createDairyRequest.toEntity(user);
        List<File> photoList = fileHandler.parseFileInfo(files);
        //파일이 존재할 때만 처리
        if(!photoList.isEmpty()) {
            List<File> list = new ArrayList<>();
            for(File photo : photoList) {
                // 파일을 DB에 저장
             list.add(photoRepository.save(photo));
            }
            diary.updatePhoto(list);
        }
        diaryFacade.saveDiary(diary);
    }
}
