package com.auth.controller;

import com.auth.service.AuthService;
import com.auth.vo.LoginFormVO;
import com.data.client.Client;
import com.data.client.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginFormVO loginFormVO) {
        return authService.login(loginFormVO.getEmail(), loginFormVO.getPassword());
    }

    @PostMapping("/register")
    public ClientDTO register(@RequestBody Client client) {
        return authService.register(client);
    }

}