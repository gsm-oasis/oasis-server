package com.real.realoasis.domain.diary.entity;

import com.real.realoasis.domain.image.data.entity.Image;
import com.real.realoasis.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Image> images;
    private String mood;
    private String createDate;
    private String title;
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void updateImages(List<Image> images) {
        this.images = images;
    }

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public void update(String title, String content, String mood){
        this.title = title;
        this.content = content;
        this.mood = mood;
    }
}
