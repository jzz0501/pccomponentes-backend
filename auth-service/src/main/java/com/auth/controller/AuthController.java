package com.auth.controller;

import com.auth.service.AuthService;
import com.auth.vo.LoginFormVO;
import com.data.client.Client;
import com.data.client.ClientDTO;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth", produces = "application/json;charset=UTF-8")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginFormVO loginFormVO) {
        return new GsonBuilder().create().toJson(authService.login(loginFormVO.getEmail(), loginFormVO.getPassword()));
    }

    @PostMapping("/register")
    public ClientDTO register(@RequestBody Client client) {
        return authService.register(client);
    }

}