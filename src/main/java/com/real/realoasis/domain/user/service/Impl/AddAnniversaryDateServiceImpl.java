package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.entity.CoupleAnniversaryDate;
import com.real.realoasis.domain.couple.domain.repository.CoupleAnniversaryDateRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.exception.DuplicateAnniversaryDateException;
import com.real.realoasis.domain.user.exception.IsNotCoupleUserException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.AddAnniversaryDateService;
import com.real.realoasis.domain.user.util.UserConverter;
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
    private final UserConverter userConverter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(String anniversaryDate) {
        User currentUser = userFacade.currentUser();
        Couple couple;
        if(currentUser.getIsCouple()) {
            couple = currentUser.getCouple();
        } else
            throw new IsNotCoupleUserException(ErrorCode.IS_NOT_COUPLE_USER);

        List<CoupleAnniversaryDate> coupleAnniversaryDateList = coupleAnniversaryDateRepository.findAllByCouple(couple);
        for (CoupleAnniversaryDate coupleAnniversaryDate: coupleAnniversaryDateList) {
            if(coupleAnniversaryDate.getAnniversaryDate().equals(anniversaryDate))
                throw new DuplicateAnniversaryDateException(ErrorCode.DUPLICATE_ANNIVERSARY);
        }

        coupleAnniversaryDateRepository.save(userConverter.toEntity(anniversaryDate, couple));
    }
}
