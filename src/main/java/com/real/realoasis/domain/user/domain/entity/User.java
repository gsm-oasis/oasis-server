package com.real.realoasis.domain.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseIdEntity {
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;
    private Boolean isCouple;
    @Column(nullable = false)
    private String coupleCode;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Couple couple;

    public void updateIsCouple() {
        this.isCouple = true;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}