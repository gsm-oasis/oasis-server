package com.real.realoasis.domain.diary.facade;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.diary.exception.DiaryNotFoundException;
import com.real.realoasis.domain.diary.domain.repository.DiaryRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DiaryFacade {
    private final DiaryRepository diaryRepository;

    @Transactional(rollbackFor = Exception.class)
    public Diary findDiaryById(Long idx) {
        return diaryRepository.findDiaryByIdx(idx).orElseThrow(() -> new DiaryNotFoundException(ErrorCode.DIARY_NOT_FOUND_EXCEPTION));
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveDiary(Diary diary) {
        diaryRepository.save(diary).createDate();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteDiary(Long diaryId) {
        diaryRepository.deleteById(diaryId);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Diary> findAllByUser(User user){
        return diaryRepository.findAllByUser(user);
    }


}
