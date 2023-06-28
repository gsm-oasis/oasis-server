package com.real.realoasis.domain.couple.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Couple extends BaseIdEntity {
    @Column(nullable = false)
    private String startDay;
    @Column(nullable = false)
    private String today;
    @Column(nullable = false)
    private long datingDate;
    @Column(nullable = false)
    private String registeredDay;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private User userA;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private User userB;

    @OneToOne(fetch = FetchType.LAZY)
    private Heart heart;


    public void updateStartDay(String startDay){
        this.startDay = startDay;
    }

    @PrePersist
    public void today(){
        this.today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public void updateDatingDate(long datingDate) {
        this.datingDate = datingDate;
    }

    public void updateUserB(User currentUser) {
        this.userB = currentUser;
    }
}
