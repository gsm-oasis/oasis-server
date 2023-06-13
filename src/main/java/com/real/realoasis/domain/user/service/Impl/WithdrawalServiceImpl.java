package com.real.realoasis.domain.user.service.Impl;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.domain.repository.UserRepository;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.domain.user.service.WithdrawalService;
import com.real.realoasis.domain.user.util.UserConverter;
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
