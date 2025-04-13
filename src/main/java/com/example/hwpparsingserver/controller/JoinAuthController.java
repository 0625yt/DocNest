package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.domain.UserJoinDomain;
import com.example.hwpparsingserver.service.UserJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class JoinAuthController {

    @Autowired
    private UserJoinService userJoinService;

    @PostMapping("/join")
    public ResponseEntity<Map<String, String>> join(@RequestBody UserJoinDomain userJoinDomain) {
        Map<String, String> response = userJoinService.registerUser(userJoinDomain);
        return ResponseEntity.ok(response); // JSON 형식으로 응답
    }

}
