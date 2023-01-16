package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.data.dto.DiaryListDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListResponse;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.service.DiaryService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.image.service.ImageService;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class DiaryServiceImpl implements DiaryService {
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;
    private final ImageService imageService;
    private final DiaryConverter diaryConverter;
    @Override
    public void createDiary(CreateDiaryDto createDiaryDto, List<MultipartFile> files) throws Exception{
        User user = userFacade.currentUser();
        // 파일 처리를 위한 Diary 객체 생성
        Diary diary = diaryConverter.toEntity(createDiaryDto, user);
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

    @Override
    public void deleteDiary(Long diaryId) {
        diaryFacade.deleteDiary(diaryId);
    }

    @Override
    public DiaryDetailResponse getDetail(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        String date = diary.getCreateDate();
        String year = date.substring(0,3);
        String month = date.substring(4,5);
        String day = date.substring(6,7);
        String createDate = year + "년 " + month + "월 " + day + "일";
        DiaryDetailDto diaryDetailPageDto = diaryConverter.toDetailDto(diary.getTitle(), diary.getContent(), diary.getMood(),diary.getImages(), createDate);
        return diaryConverter.toDetailResponse(diaryDetailPageDto);
    }

    @Override
    public void editDiary(Long diaryId, EditDiaryDto editDiaryDto, List<MultipartFile> files) throws Exception {
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
        editDiary.update(editDiaryDto.getTitle(), editDiaryDto.getContent(), editDiaryDto.getMood());
        diaryFacade.saveDiary(editDiary);
    }

    @Override
    public DiaryListResponse getList() {
        User currentUser = userFacade.currentUser();
        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        List<Diary> diaryList = diaryFacade.findAllByUserId(currentUser.getId());
        List<Diary> diaryCoupleList = diaryFacade.findAllByUserId(coupleUser.getId());

        List<Diary> mergedList = Stream.of(diaryList, diaryCoupleList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<DiaryListDto> diaryListPageDto = diaryConverter.toListDto(mergedList);
        return diaryConverter.toListResponse(diaryListPageDto);
    }
}
