package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.data.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.service.GetDiaryDetailService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.image.domain.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetDiaryDetailServiceImpl implements GetDiaryDetailService {
    private final DiaryFacade diaryFacade;
    private final DiaryConverter diaryConverter;
    private final ImageRepository imageRepository;

    @Override
    public DiaryDetailDto get(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        List<Image> images = imageRepository.findByDiary(diary);
        String date = diary.getCreateDate();
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6,8);
        String createDate = year + "년 " + month + "월 " + day + "일";
        return diaryConverter.toDetailDto(diary, images, createDate);
    }
}
