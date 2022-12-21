package com.real.realoasis.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "refresh-token")
public class RefreshToken {
    @Id
    private String userId;
    private String refreshToken;
    private LocalDateTime timeToLive;
}
