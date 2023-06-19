package com.real.realoasis.domain.question.domain.entity;

import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Question extends BaseIdEntity {
    @Column(nullable = false)
    private String content;
}
