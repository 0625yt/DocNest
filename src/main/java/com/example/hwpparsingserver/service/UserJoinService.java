package com.example.hwpparsingserver.service;

import com.example.hwpparsingserver.domain.UserJoinDomain;
import com.example.hwpparsingserver.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserJoinService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    // 회원가입 메서드
    public Map<String, String> registerUser(UserJoinDomain userJoinDomain) {
        Map<String, String> response = new HashMap<>();

        // 중복 사용자 체크
        if (jpaUserRepository.findByUserId(userJoinDomain.getUserId()) != null) {
            response.put("status", "failure");
            response.put("message", "이미 존재하는 아이디입니다.");
            return response;
        }
        if (jpaUserRepository.findByEmail(userJoinDomain.getEmail()) != null) {
            response.put("status", "failure");
            response.put("message", "이미 사용 중인 이메일입니다.");
            return response;
        }

        // 사용자 저장
        jpaUserRepository.save(userJoinDomain);
        System.out.println("회원 정보가 저장되었습니다: " + userJoinDomain.toString());

        response.put("status", "success");
        response.put("message", "회원가입이 성공적으로 완료되었습니다.");
        return response;
    }
}
