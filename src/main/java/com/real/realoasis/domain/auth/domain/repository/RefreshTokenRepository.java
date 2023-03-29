package com.real.realoasis.domain.auth.domain.repository;

import com.real.realoasis.domain.auth.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByToken(String refreshToken);
}
