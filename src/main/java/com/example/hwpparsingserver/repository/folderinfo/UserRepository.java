package com.example.hwpparsingserver.repository.folderinfo;

import com.example.hwpparsingserver.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
}