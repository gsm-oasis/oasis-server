package com.real.realoasis.domain.couple.domain.entity;

import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Couple extends BaseIdEntity {

}
