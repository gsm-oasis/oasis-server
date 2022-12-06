package com.real.realoasis.domain.diary.entity;

import com.real.realoasis.domain.photo.entity.Photo;
import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private List<Photo> photo = new ArrayList<>();

    public void updatePhoto(List<Photo> photo) {
        this.photo = photo;
    }
    private String mood;


    private LocalDateTime createDate;
    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

    private String title;

    private String writer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
