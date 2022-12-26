package com.real.realoasis.domain.image.data.entity;

import com.real.realoasis.domain.diary.entity.Diary;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @Builder
    public Image(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
