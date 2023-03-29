package com.real.realoasis.domain.user.data.entity;

import com.real.realoasis.domain.heart.data.entity.Heart;
import com.real.realoasis.domain.user.type.Role;
import com.real.realoasis.global.entity.BaseIdEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseIdEntity {
    private String id;
    private String email;
    @NotNull
    private String password;
    private String nickname;
    private boolean isCouple;
    private long anniversaryDate;

    private String coupleCode;
    private String coupleId;
    private String firstDay;
    private String today;
    private long datingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Heart heart;

    public void updateHeart(Heart heart){
        this.heart = heart;
    }

    public void updateIsCouple() {
        this.isCouple = true;
    }

    public void updateCoupleId(String coupleId){
        this.coupleId = coupleId;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePassword(String password) {
        this.password = password;
    }


    public void updateAnniversaryTime(long anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public void createFirstDay(String firstDay){
        this.firstDay = firstDay;
    }

    @PrePersist
    public void today(){
        this.today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public void updateDatingDate(long datingDate) {
        this.datingDate = datingDate;
    }
}