package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WithdrawalServiceImpl implements WithdrawalService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Override
    public void withdrawal() {
        User user = userFacade.currentUser();
        userRepository.delete(user);
    }
}
