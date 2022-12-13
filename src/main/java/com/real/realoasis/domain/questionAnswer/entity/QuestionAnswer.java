package com.real.realoasis.domain.questionAnswer.entity;

import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer1;

    private String answer2;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void updateAnswer(String answer){
        if(this.answer1 == null) {
            this.answer1 = answer;
        }
        else {
            this.answer2 = answer;
        }
    }
}
