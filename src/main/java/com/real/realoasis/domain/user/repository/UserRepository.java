package com.real.realoasis.domain.user.repository;


import com.real.realoasis.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByCoupleCode(String code);
    boolean existsByEmail(String email);
}
