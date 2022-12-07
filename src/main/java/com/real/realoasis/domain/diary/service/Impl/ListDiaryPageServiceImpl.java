package com.real.realoasis.domain.diary.service.Impl;

import com.real.realoasis.domain.diary.facade.DiaryFacade;
import com.real.realoasis.domain.diary.presentation.dto.response.ListDiaryPageResponse;
import com.real.realoasis.domain.diary.repository.DiaryRepository;
import com.real.realoasis.domain.diary.service.ListDiaryPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListDiaryPageServiceImpl implements ListDiaryPageService {
    private final DiaryFacade diaryFacade;
    private final DiaryRepository diaryRepository;


    @Override
    public List<ListDiaryPageResponse> getList() {
        List<ListDiaryPageResponse> list = new ArrayList<>();
        diaryRepository.findAll().forEach(diary -> {
            Long diaryId = diary.getId();
            String content = diary.getContent();
            String mood = diary.getMood();
            String title = diary.getTitle();
            String writer = diary.getWriter();
            LocalDateTime createDate = diary.getCreateDate();
            list.add(new ListDiaryPageResponse(diaryId, content, mood, title, writer, createDate));
        });
        return list;
    }
}
