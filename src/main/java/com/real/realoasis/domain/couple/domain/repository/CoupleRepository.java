package com.real.realoasis.domain.couple.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
    Couple findByCoupleId(String id);
}
