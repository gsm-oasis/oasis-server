package com.real.realoasis.domain.user.entity;

import com.real.realoasis.domain.user.type.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String email;

    @NotNull
    private String password;

    private String nickName;
    @Column(name = "refresh_token")
    private String refreshToken;

    @ElementCollection(fetch = FetchType.EAGER) // roles 컬렉션
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id"))
    @Builder.Default
    private List<Role> roles = new ArrayList<>();

    private String code;

    private String coupleId;

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void updateCoupleId(String coupleId){
        this.coupleId = coupleId;
    }



}
