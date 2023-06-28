package com.real.realoasis.domain.user.domain.repository;


import com.real.realoasis.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUserId(String id);
    Optional<User> findUserByEmail(String email);
    User findByCoupleCode(String coupleCode);
    boolean existsByUserId(String id);
}
