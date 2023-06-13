package com.real.realoasis.domain.heart.domain.repository;

import com.real.realoasis.domain.heart.domain.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
}
