package com.real.realoasis.domain.anniversary.service.impl;

import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.anniversary.domain.repository.CoupleAnniversaryDateRepository;
import com.real.realoasis.domain.anniversary.presentation.data.dto.AnniversaryListDto;
import com.real.realoasis.domain.anniversary.service.GetAnniversaryListService;
import com.real.realoasis.domain.anniversary.util.AnniversaryConverter;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAnniversaryListServiceImpl implements GetAnniversaryListService {
    private final CoupleAnniversaryDateRepository coupleAnniversaryDateRepository;
    private final UserFacade userFacade;
    private final AnniversaryConverter anniversaryConverter;

    @Override
    public List<AnniversaryListDto> get() {
        User user = userFacade.currentUser();
        Couple couple = user.getCouple();
        List<CoupleAnniversaryDate> coupleAnniversaryDateList = coupleAnniversaryDateRepository.findAllByCouple(couple);
        return coupleAnniversaryDateList.stream()
                .map(anniversaryConverter::toDto)
                .collect(Collectors.toList());
    }
}
