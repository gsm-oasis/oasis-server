package com.real.realoasis.domain.couple.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
    boolean existsByUserA(User currentUser);
    boolean existsByUserB(User currentUser);
    Couple findByUserA(User currentUser);
    Couple findByUserB(User currentUser);
}
