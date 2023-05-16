package com.real.realoasis.domain.auth.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refresh", timeToLive = 60L * 60 * 24 * 7)
public class RefreshToken {
    @Id
    @Indexed
    private String userId;
    @Indexed
    private String token;

    @Builder
    public RefreshToken(String userId, String token){
        this.userId = userId;
        this.token = token;
    }
}
