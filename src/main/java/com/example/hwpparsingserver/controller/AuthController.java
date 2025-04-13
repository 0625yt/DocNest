package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> requestBody) {
        Map<String, Object> response = new HashMap<>();
        String userId = requestBody.get("userId");
        String userPw = requestBody.get("userPw");

        if (userId == null || userPw == null) {
            response.put("status", "failure");
            response.put("message", "Required parameters are missing.");
            return ResponseEntity.badRequest().body(response);
        }
        System.out.println(userId);
        System.out.println(userPw);
        boolean isAuthenticated = userService.authUserWithJPA(userId, userPw);
        if (isAuthenticated) {
            response.put("status", "success");
            response.put("message", "Authentication successful");
        } else {
            System.out.println("fail");
            response.put("status", "failure");
            response.put("message", "Authentication failed");
        }

        return ResponseEntity.ok(response);
    }
}
