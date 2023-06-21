package com.real.realoasis.domain.heart.domain.entity;

import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Heart extends BaseIdEntity {
    @Column(nullable = false)
    private long levelBar;
    @Column(nullable = false)
    private int level;
}
