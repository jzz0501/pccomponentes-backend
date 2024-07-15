package com.auth.service;

import com.api.ClientAPI;
import com.data.client.Client;
import com.data.client.ClientDTO;
import com.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements iAuthService {

    @Autowired
    ClientAPI clientAPI;

    @Override
    public String login(String username, String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", username);
        claims.put("password", password);
        return JWT.generateJwt(claims);
    }

    @Override
    public ClientDTO register(Client client) {
        return clientAPI.postClient(client);
    }

}
