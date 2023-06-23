package com.real.realoasis.domain.couple.domain.entity;

import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedAnniversaryDate extends BaseIdEntity {
    @Column(nullable = false)
    private long anniversaryDate;

    @Builder
    public FixedAnniversaryDate(long anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }
}
