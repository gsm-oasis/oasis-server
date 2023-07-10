package com.real.realoasis.domain.anniversary.service.impl;

import com.real.realoasis.domain.anniversary.presentation.data.request.AddAnniversaryRequest;
import com.real.realoasis.domain.anniversary.util.AnniversaryConverter;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.anniversary.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.anniversary.domain.repository.CoupleAnniversaryDateRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.exception.DuplicateAnniversaryDateException;
import com.real.realoasis.domain.user.exception.IsNotCoupleUserException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.anniversary.service.AddAnniversaryDateService;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddAnniversaryDateServiceImpl implements AddAnniversaryDateService {
    private final UserFacade userFacade;
    private final CoupleAnniversaryDateRepository coupleAnniversaryDateRepository;
    private final AnniversaryConverter anniversaryConverter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddAnniversaryRequest addAnniversaryRequest) {
        User currentUser = userFacade.currentUser();
        Couple couple;
        if(currentUser.getIsCouple()) {
            couple = currentUser.getCouple();
        } else
            throw new IsNotCoupleUserException(ErrorCode.IS_NOT_COUPLE_USER);

        List<CoupleAnniversaryDate> coupleAnniversaryDateList = coupleAnniversaryDateRepository.findAllByCouple(couple);
        for (CoupleAnniversaryDate coupleAnniversaryDate: coupleAnniversaryDateList) {
            if(coupleAnniversaryDate.getAnniversaryDate().equals(addAnniversaryRequest.getAnniversaryDate()))
                throw new DuplicateAnniversaryDateException(ErrorCode.DUPLICATE_ANNIVERSARY);
        }

        coupleAnniversaryDateRepository.save(anniversaryConverter.toEntity(addAnniversaryRequest, couple));
    }
}
