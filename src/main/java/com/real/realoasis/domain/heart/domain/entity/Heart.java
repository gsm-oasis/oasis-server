package com.real.realoasis.domain.heart.domain.entity;

import com.real.realoasis.global.entity.BaseIdEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Heart extends BaseIdEntity {
    @Column(nullable = false)
    private long levelBar;
    @Column(nullable = false)
    private int level;

    public void updateLevelBar() {
        ++this.levelBar;
        if(levelBar <= 50)
            ++this.level;
        else if (levelBar <= 150)
            ++this.level;
        else if (levelBar <= 250)
            ++this.level;
        else if (levelBar <= 400)
            ++this.level;
        else if (levelBar <= 600)
            ++this.level;
        else if (levelBar <= 800)
            ++this.level;
        else if (levelBar <= 1000)
            ++this.level;
        else if (levelBar <= 1300)
            ++this.level;
        else if (levelBar <= 1600)
            ++this.level;
        else if (levelBar <= 2000)
            ++this.level;
        else if (levelBar <= 2500)
            ++this.level;
        else if (levelBar <= 3000)
            ++this.level;
        else
            ++this.level;
    }
}
