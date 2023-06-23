package com.real.realoasis.domain.couple.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnniversaryDate extends BaseIdEntity {
    @Column(nullable = false)
    private long anniversaryDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Couple couple;

    @Builder
    public AnniversaryDate(long anniversaryDate, Couple couple) {
        this.anniversaryDate = anniversaryDate;
        this.couple = couple;
    }
}
