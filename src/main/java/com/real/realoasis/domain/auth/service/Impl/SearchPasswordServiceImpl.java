package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.SearchPwDto;
import com.real.realoasis.domain.auth.service.SearchPasswordService;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SearchPasswordServiceImpl implements SearchPasswordService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void searchPW(SearchPwDto searchPwDto) {
        User user = userFacade.findUserByEmail(searchPwDto.getEmail());
        user.updatePassword(passwordEncoder.encode(searchPwDto.getPassword()));
    }
}
