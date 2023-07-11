package com.real.realoasis.domain.anniversary.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CoupleAnniversaryDateRepository extends JpaRepository<CoupleAnniversaryDate, Long> {
    List<CoupleAnniversaryDate> findAllByCouple(Couple couple);
    CoupleAnniversaryDate findByAnniversaryDate(String coupleAnniversaryDate);
}
