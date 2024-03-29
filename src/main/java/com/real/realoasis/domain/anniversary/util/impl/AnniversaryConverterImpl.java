package com.real.realoasis.domain.anniversary.util.impl;

import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.anniversary.presentation.data.dto.AnniversaryListDto;
import com.real.realoasis.domain.anniversary.presentation.data.request.AddAnniversaryRequest;
import com.real.realoasis.domain.anniversary.presentation.data.response.AnniversaryListResponse;
import com.real.realoasis.domain.anniversary.util.AnniversaryConverter;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import org.springframework.stereotype.Component;

@Component
public class AnniversaryConverterImpl implements AnniversaryConverter {
    @Override
    public CoupleAnniversaryDate toEntity(AddAnniversaryRequest addAnniversaryRequest, Couple couple) {
        return new CoupleAnniversaryDate(
                addAnniversaryRequest.getAnniversaryName(),
                addAnniversaryRequest.getAnniversaryDate(),
                couple
        );
    }

    @Override
    public AnniversaryListDto toDto(CoupleAnniversaryDate coupleAnniversaryDate) {
        return AnniversaryListDto.builder()
                .idx(coupleAnniversaryDate.getIdx())
                .date(coupleAnniversaryDate.getAnniversaryDate())
                .name(coupleAnniversaryDate.getAnniversaryName())
                .build();
    }

    @Override
    public AnniversaryListResponse toResponse(AnniversaryListDto anniversaryListDto) {
        return AnniversaryListResponse.builder()
                .idx(anniversaryListDto.getIdx())
                .date(anniversaryListDto.getDate())
                .name(anniversaryListDto.getName())
                .build();
    }
}
