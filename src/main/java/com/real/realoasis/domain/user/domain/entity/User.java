package com.real.realoasis.domain.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseIdEntity {
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private Boolean isCouple;
    @Column(nullable = false)
    private String coupleCode;
    @Column(nullable = false)
    private int diaryCount;

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

    public void updateCouple(Couple couple) {
        this.couple = couple;
    }

    public void unConnectCouple() {
        this.isCouple = false;
        this.couple = null;
    }

    public int addDiaryCount() {
        return ++this.diaryCount;
    }

    public void resetDailyCount() {
        this.diaryCount = 0;
    }
}