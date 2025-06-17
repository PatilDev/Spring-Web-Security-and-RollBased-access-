package com.dev.springsecurity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.springsecurity.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
