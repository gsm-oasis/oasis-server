package com.real.realoasis.domain.user.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String email;

    @NotNull
    private String password;

    private String name;
    @Column(name = "refresh_token")
    private String refreshToken;

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public User(String email, String password, String refreshToken){
        this.email = email;
        this.password = password;
        this.refreshToken = refreshToken;
    }



}
