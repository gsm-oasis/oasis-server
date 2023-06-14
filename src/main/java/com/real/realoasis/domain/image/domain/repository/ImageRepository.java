package com.real.realoasis.domain.image.domain.repository;

import com.real.realoasis.domain.diary.domain.entity.Diary;
import com.real.realoasis.domain.image.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByDiary(Diary diary);
}
