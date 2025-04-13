package com.example.hwpparsingserver.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "USERDOMAIN") // 테이블 이름 명시
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // USER_ID 자동 매핑
    private String userId;

    @Column(nullable = false) // USER_PW 자동 매핑
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    // 기본 생성자
    public UserDomain() {}

    // 생성자
    public UserDomain(String userId, String userPw, String userName, String email) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
