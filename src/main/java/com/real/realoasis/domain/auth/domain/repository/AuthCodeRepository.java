package com.real.realoasis.domain.auth.domain.repository;

import com.real.realoasis.domain.auth.domain.entity.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
}
