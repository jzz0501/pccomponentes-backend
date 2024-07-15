package com.auth.service;

import com.data.client.Client;
import com.data.client.ClientDTO;

public interface iAuthService {

    String login(String username, String password);

    ClientDTO register(Client client);

}