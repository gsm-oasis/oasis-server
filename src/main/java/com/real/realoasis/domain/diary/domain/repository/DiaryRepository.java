package com.real.realoasis.domain.diary.domain.repository;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findDiaryByIdx(Long idx);
    List<Diary> findAllByUser(User user);
}
