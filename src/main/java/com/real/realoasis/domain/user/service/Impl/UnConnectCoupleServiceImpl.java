package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.UnConnectCoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnConnectCoupleServiceImpl implements UnConnectCoupleService {
    private final UserFacade userFacade;
    private final CoupleRepository coupleRepository;
    @Override
    public void unConnect() {
        User currentUser = userFacade.currentUser();
        Couple couple = currentUser.getCouple();
        User coupleUser;
        if(currentUser.equals(couple.getUserA()))
            coupleUser = couple.getUserB();
        else
            coupleUser = couple.getUserA();

        currentUser.unConnectCouple();
        coupleUser.unConnectCouple();
        coupleRepository.delete(couple);
    }
}
