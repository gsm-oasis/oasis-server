package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.DiaryDetailDto;
import com.real.realoasis.domain.diary.presentation.response.DiaryDetailResponse;
import com.real.realoasis.domain.diary.service.GetDiaryDetailService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDiaryDetailServiceImpl implements GetDiaryDetailService {
    private final DiaryFacade diaryFacade;
    private final DiaryConverter diaryConverter;
    @Override
    public DiaryDetailResponse get(Long diaryId) {
        Diary diary = diaryFacade.findDiaryById(diaryId);
        String date = diary.getCreateDate();
        String year = date.substring(0,3);
        String month = date.substring(4,5);
        String day = date.substring(6,7);
        String createDate = year + "년 " + month + "월 " + day + "일";
        DiaryDetailDto diaryDetailPageDto = diaryConverter.toDetailDto(diary.getTitle(), diary.getContent(), diary.getMood(),diary.getImages(), createDate);
        return diaryConverter.toDetailResponse(diaryDetailPageDto);
    }
}
