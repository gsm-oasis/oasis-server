package com.real.realoasis.domain.auth.presentation.dto.request;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String email;
    private String password;
    private String nickName;


    public User toEntity(String password) {
        return User.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .roles(Collections.singletonList(Role.ROLE_USER))
                .build();
    }

}
