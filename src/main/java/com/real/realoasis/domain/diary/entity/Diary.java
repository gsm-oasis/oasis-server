package com.real.realoasis.domain.diary.entity;

import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String image;

    private String mood;

    private String date;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete( action = OnDeleteAction.CASCADE)
    private User user;
}
