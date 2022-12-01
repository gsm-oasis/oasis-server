package com.real.realoasis.domain.user.facade;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.exception.PasswordNotMatchException;
import com.real.realoasis.domain.user.exception.UserNotFoundException;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveUser(SignUpRequest signUpRequest) {
        userRepository.save(signUpRequest.toEntity(passwordEncoder.encode(signUpRequest.getPassword())));
    }

    @Transactional(rollbackFor = Exception.class)
    public User findUserById(String id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
    }

    @Transactional(rollbackFor = Exception.class)
    public String findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordNotMatchException(ErrorCode.PASSWORD_NOT_MATCH_EXCEPTION);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public User currentUser() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return findUserById(id);
    }

}
