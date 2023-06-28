package com.real.realoasis.domain.couple.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoupleAnniversaryDate extends BaseIdEntity {
    @Column(nullable = false)
    private String anniversaryDate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Couple couple;

    @Builder
    public CoupleAnniversaryDate(String anniversaryDate, Couple couple) {
        this.anniversaryDate = anniversaryDate;
        this. couple = couple;
    }
}
