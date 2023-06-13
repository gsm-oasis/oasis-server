package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.DiaryListDto;
import com.real.realoasis.domain.diary.presentation.response.DiaryListResponse;
import com.real.realoasis.domain.diary.service.GetDiaryDetailService;
import com.real.realoasis.domain.diary.service.GetDiaryListService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GetDiaryListServiceImpl implements GetDiaryListService {
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;
    private final DiaryConverter diaryConverter;

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
