package com.real.realoasis.domain.questionAnswer.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionAnswer extends BaseIdEntity {
    private String answerA;
    private String answerB;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Couple couple;

    public void writeA(String answer) {
        this.answerA = answer;
    }

    public void writeB(String answer) {
        this.answerB = answer;
    }
}
