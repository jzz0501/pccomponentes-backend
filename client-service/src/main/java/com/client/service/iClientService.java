package com.client.service;

import com.data.client.Client;
import com.data.client.ClientDTO;

public interface iClientService {

    ClientDTO addClient(Client client);

    ClientDTO findClientByEmailAndPassword(String email, String password);

    ClientDTO findClientById(Long id_client);



}
