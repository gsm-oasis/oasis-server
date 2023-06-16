package com.real.realoasis.domain.user.domain.entity;

import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private boolean isCouple;
    @Column(nullable = false)
    private String startDay;
    @Column(nullable = false)
    private String today;
    @Column(nullable = false)
    private long datingDate;
    @Column(nullable = false)
    private long anniversaryDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Heart heart;

    @PrePersist
    public void today(){
        this.today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public void updateHeart(Heart heart){
        this.heart = heart;
    }

    public void updateIsCouple() {
        this.isCouple = true;
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

    public void updateStartDay(String startDay){
        this.startDay = startDay;
    }

    public void updateDatingDate(long datingDate) {
        this.datingDate = datingDate;
    }
}