package com.example.hwpparsingserver.repository.folderinfo;

import com.example.hwpparsingserver.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> findByUserId(String userId);
}