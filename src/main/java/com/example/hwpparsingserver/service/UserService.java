package com.example.hwpparsingserver.service;

import com.example.hwpparsingserver.domain.UserDomain;
import com.example.hwpparsingserver.repository.JpaLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JpaLoginRepository jpaLoginRepository;

    // 사용자 인증
    public boolean authUserWithJPA(String userId, String userPw) {
        UserDomain foundUser = jpaLoginRepository.authUser(userId, userPw);
        System.out.println(foundUser);

        if (foundUser == null) {
            return false;
        }else{
            return true;
        }
    }
}
