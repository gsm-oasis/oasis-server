package com.real.realoasis.domain.user.repository;


import com.real.realoasis.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findUserById(String id);
}
