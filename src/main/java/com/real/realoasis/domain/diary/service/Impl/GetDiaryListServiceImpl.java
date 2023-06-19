package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.data.dto.DiaryDto;
import com.real.realoasis.domain.diary.service.GetDiaryListService;
import com.real.realoasis.domain.diary.util.DiaryConverter;
import com.real.realoasis.domain.user.domain.entity.User;
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
    private final CoupleRepository coupleRepository;

    @Override
    public List<DiaryDto> getList() {
        User currentUser = userFacade.currentUser();
        User coupleUser = coupleRepository.findByCoupleId(currentUser.getId()).getUser();

        List<Diary> diaryList = diaryFacade.findAllByUser(currentUser);
        List<Diary> diaryCoupleList = diaryFacade.findAllByUser(coupleUser);

        List<Diary> mergedList = Stream.of(diaryList, diaryCoupleList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return diaryConverter.toDto(mergedList, currentUser);
    }

}
