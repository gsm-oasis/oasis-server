package com.real.realoasis.domain.diary.repository;

import com.real.realoasis.domain.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findDiaryById(Long id);

    boolean existsById(Long id);
}
