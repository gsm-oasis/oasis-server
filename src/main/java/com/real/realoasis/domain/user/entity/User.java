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
    @Column(name = "user_id")
    private String id;

    private String email;

    @NotNull
    private String password;

    private String nickName;

    private String questionTime;

    private String anniversaryTime;

    private String code;

    private String coupleId;

    @Column(name = "refresh_token")
    private String refreshToken;

    @ElementCollection(fetch = FetchType.EAGER) // roles 컬렉션
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id"))
    @Builder.Default
    private List<Role> roles = new ArrayList<>();

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void updateCoupleId(String coupleId){
        this.coupleId = coupleId;
    }

    public void updateNickname(String nickName) {
        this.nickName = nickName;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

}
