package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.data.dto.CreateDiaryDto;
import com.real.realoasis.domain.diary.data.dto.EditDiaryDto;
import com.real.realoasis.domain.diary.data.entity.Diary;
import com.real.realoasis.domain.diary.data.request.DiaryEditRequest;
import com.real.realoasis.domain.diary.data.response.DiaryDetailPageResponse;
import com.real.realoasis.domain.diary.data.response.DiaryListPageResponse;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.data.request.DiaryCreateRequest;
import com.real.realoasis.domain.diary.service.DiaryService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.image.service.ImageService;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    public DiaryDetailPageResponse getDetailPage(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        String cd = diary.getCreateDate(); //20221216
        String year = cd.substring(0,3);
        String month = cd.substring(4,5);
        String day = cd.substring(6,7);
        String createDate = year + "년 " + month + "월 " + day + "일";
        return new DiaryDetailPageResponse(diary.getTitle(), diary.getContent(), diary.getMood(),diary.getImages(), createDate);
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
    public Stream<DiaryListPageResponse> getList() {
        User currentUser = userFacade.currentUser();

        User coupleUser = userFacade.findUserById(currentUser.getCoupleId());

        List<DiaryListPageResponse> list = new ArrayList<>();

        diaryFacade.findAllByUserId(currentUser.getId()).forEach(diary -> {
            Long diaryId = diary.getId();
            String content = diary.getContent();
            String title = diary.getTitle();
            String writer = diary.getWriter();
            String createDate = diary.getCreateDate();
            list.add(new DiaryListPageResponse(diaryId, content, title, writer, createDate));
        });
        diaryFacade.findAllByUserId(coupleUser.getId()).forEach(diary -> {
            Long diaryId = diary.getId();
            String content = diary.getContent();
            String title = diary.getTitle();
            String writer = diary.getWriter();
            String createDate = diary.getCreateDate();
            list.add(new DiaryListPageResponse(diaryId, content, title, writer, createDate));
        });
        return list.stream()
                .sorted(Comparator.comparing(DiaryListPageResponse::getDiaryId).reversed());
    }
}
