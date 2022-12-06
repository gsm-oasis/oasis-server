package com.real.realoasis.domain.diary.facade;

import com.real.realoasis.domain.diary.entity.Diary;
import com.real.realoasis.domain.diary.exception.DiaryNotFoundException;
import com.real.realoasis.domain.diary.repository.DiaryRepository;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.exception.UserNotFoundException;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DiaryFacade {
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public boolean existsById(Long id) {
        return diaryRepository.existsById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Diary findDiaryById(Long id) {
        return diaryRepository.findDiaryById(id).orElseThrow(() -> new DiaryNotFoundException(ErrorCode.DIARY_NOT_FOUND_EXCEPTION));
    }



}
