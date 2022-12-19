package com.real.realoasis.domain.auth.presentation.dto.request;

import com.real.realoasis.domain.user.entity.User;
import com.real.realoasis.domain.user.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Random;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String id;
    private String email;
    private String password;
    private String nickname;


    public User toEntity(String password, String code) {
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .anniversaryTime("7")
                .nickname(nickname)
                .code(code)
                .roles(Collections.singletonList(Role.ROLE_USER))
                .build();
    }

}
