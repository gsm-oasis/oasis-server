package com.real.realoasis.domain.photo.repository;

import com.real.realoasis.domain.photo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}