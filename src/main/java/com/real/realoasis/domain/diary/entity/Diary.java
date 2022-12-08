package com.real.realoasis.domain.diary.entity;

import com.real.realoasis.domain.file.entity.File;
import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany
    private List<File> photo = new ArrayList<>();
    private String mood;
    private String createDate;
    private String title;
    private String writer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void updatePhoto(List<File> photo) {
        this.photo = photo;
    }

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
