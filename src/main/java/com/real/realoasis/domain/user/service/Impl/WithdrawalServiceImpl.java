package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.couple.domain.repository.CoupleRepository;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.domain.repository.UserRepository;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WithdrawalServiceImpl implements WithdrawalService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final CoupleRepository coupleRepository;

    @Override
    public void withdrawal() {
        User currentUser = userFacade.currentUser();
        if(currentUser.getIsCouple()) {
            Couple couple = currentUser.getCouple();
            User coupleUser;
            if(currentUser.equals(couple.getUserA()))
                coupleUser = couple.getUserB();
            else
                coupleUser = couple.getUserA();

            currentUser.unConnectCouple();
            coupleUser.unConnectCouple();
            coupleRepository.delete(couple);
            userRepository.delete(currentUser);
        }
        else
            userRepository.delete(currentUser);
    }
}
