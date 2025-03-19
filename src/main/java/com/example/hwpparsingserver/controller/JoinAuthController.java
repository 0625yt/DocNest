package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.service.UserJoinService;
import com.example.hwpparsingserver.domain.UserJoinDomain;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class JoinAuthController {

    @Autowired
    private UserJoinService userJoinService;

    @PostMapping("/join")
    public String registerUser(@RequestBody UserJoinDomain userDomain) {
        return userJoinService.registerUser(userDomain);
    }
}
