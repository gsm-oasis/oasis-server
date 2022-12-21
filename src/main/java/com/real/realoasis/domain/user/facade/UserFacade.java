package com.real.realoasis.domain.user.facade;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.SignupResponse;
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

import java.util.Random;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserFacade {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    public SignupResponse saveUser(SignUpRequest signUpRequest) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(3);
            switch (index) {
                case 0 :
                    key.append((char) (random.nextInt(26) + 97));
                    break;
                case 1 :
                    key.append((char) (random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
                }
            }
        userRepository.save(signUpRequest.toEntity(passwordEncoder.encode(signUpRequest.getPassword()), key.toString()));
        return SignupResponse.builder()
                .code(key.toString())
                .build();
    }
    public void saveUser(User currentUser){
        userRepository.save(currentUser);
    }

    public User findUserById(String id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
    }

    public String findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user == null) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION);
        }
        return user.getId();
    }

    public User findUserByCode(String code) {
        return userRepository.findUserByCode(code).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
    }

    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordNotMatchException(ErrorCode.PASSWORD_NOT_MATCH_EXCEPTION);
        }
    }

    public User currentUser() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return findUserById(id);
    }


    public int getAnniversary(long datingDate){
        int annivesary = 100;
        if(datingDate < 100){
            annivesary = 100;
            return annivesary;
        } else if (datingDate < 200) {
            annivesary = 200;
            return annivesary;
        } else if (datingDate < 300) {
            annivesary = 300;
            return annivesary;
        }else if (datingDate < 400) {
            annivesary = 400;
            return annivesary;
        }else if (datingDate < 500) {
            annivesary = 500;
            return annivesary;
        }else if (datingDate < 600) {
            annivesary = 600;
            return annivesary;
        }else if (datingDate < 700) {
            annivesary = 700;
            return annivesary;
        }else if (datingDate < 800) {
            annivesary = 800;
            return annivesary;
        }else if (datingDate < 900) {
            annivesary = 900;
            return annivesary;
        }else if (datingDate < 1000) {
            annivesary = 1000;
            return annivesary;
        } else return annivesary;
    }

}
