package com.real.realoasis.domain.diary.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real.realoasis.domain.image.domain.entity.Image;
import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary extends BaseIdEntity {
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String mood;
    @Column(nullable = false)
    private String createDate;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String moodColor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    public void update(String title, String content, String mood){
        this.title = title;
        this.content = content;
        this.mood = mood;
    }
}
