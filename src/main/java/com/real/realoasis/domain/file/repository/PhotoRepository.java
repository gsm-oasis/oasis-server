package com.real.realoasis.domain.file.repository;

import com.real.realoasis.domain.file.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
