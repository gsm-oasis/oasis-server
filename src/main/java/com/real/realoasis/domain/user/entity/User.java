package com.real.realoasis.domain.user.entity;

import com.real.realoasis.domain.heart.entity.Heart;
import com.real.realoasis.domain.user.type.Role;
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
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String email;

    @NotNull
    private String password;

    private String nickname;

    private long anniversaryDate;

    private String code;

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