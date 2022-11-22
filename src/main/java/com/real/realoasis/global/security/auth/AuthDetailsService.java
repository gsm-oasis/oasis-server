package com.real.realoasis.global.security.auth;

import com.real.realoasis.domain.user.exception.UserNotFoundException;
import com.real.realoasis.domain.user.repository.UserRepository;
import com.real.realoasis.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username)
                .map(AuthDetails::new)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
    }
}
