package com.real.realoasis.domain.couple.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
    Couple findByCoupleId(String id);
    Couple findByCode(String code);
    Couple findByUser(User user);
}
