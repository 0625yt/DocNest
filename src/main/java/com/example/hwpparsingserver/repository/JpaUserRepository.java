package com.example.hwpparsingserver.repository;

import com.example.hwpparsingserver.domain.UserJoinDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserJoinDomain, Long> {
    UserJoinDomain findByUserId(String userId);
    UserJoinDomain findByEmail(String email);
}

