package com.real.realoasis.domain.couple.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.entity.CoupleAnniversaryDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoupleAnniversaryDateRepository extends JpaRepository<CoupleAnniversaryDate, Long> {
    List<CoupleAnniversaryDate> findAllByCouple(Couple couple);
}
