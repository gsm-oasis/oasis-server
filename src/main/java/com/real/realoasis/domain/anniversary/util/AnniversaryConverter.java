package com.real.realoasis.domain.anniversary.util;

import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.anniversary.presentation.data.dto.AnniversaryListDto;
import com.real.realoasis.domain.anniversary.presentation.data.response.AnniversaryListResponse;
import com.real.realoasis.domain.couple.domain.entity.Couple;

public interface AnniversaryConverter {
    CoupleAnniversaryDate toEntity(String anniversaryDate, Couple couple);
    AnniversaryListDto toDto(CoupleAnniversaryDate coupleAnniversaryDate);
    AnniversaryListResponse toResponse(AnniversaryListDto anniversaryListDto);
}
