package com.real.realoasis.domain.auth.service.Impl;

import com.real.realoasis.domain.auth.presentation.data.dto.CoupleCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SignupDto;
import com.real.realoasis.domain.auth.service.SignUpService;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.user.data.entity.User;
import com.real.realoasis.domain.user.exception.DuplicateIdException;
import com.real.realoasis.domain.user.facade.UserFacade;
import com.real.realoasis.global.error.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserFacade userFacade;
    private final AuthConverter authConverter;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public CoupleCodeDto signUp(SignupDto signupDto) {
        if(userFacade.existsById(signupDto.getId())){
            throw new DuplicateIdException(ErrorCode.DUPLICATE_ID_EXCEPTION);
        }

        String code = makeRandomCode();
        User user = authConverter.toEntity(signupDto, code);

        userFacade.saveUser(user);
        return authConverter.toDto(code);
    }

    private String makeRandomCode() {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    key.append((char) (random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) (random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        return key.toString();
    }
}
