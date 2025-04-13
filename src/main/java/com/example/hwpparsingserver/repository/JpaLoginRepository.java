package com.example.hwpparsingserver.repository;

import com.example.hwpparsingserver.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaLoginRepository extends JpaRepository<UserDomain, Long> {

    // userId와 userPw를 기준으로 사용자 조회
    @Query("SELECT u FROM UserDomain u WHERE u.userId = :userId AND u.userPw = :userPw")
    UserDomain authUser(@Param("userId") String userId, @Param("userPw") String userPw);
}
