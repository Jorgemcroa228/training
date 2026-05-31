package com.football.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.training.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
