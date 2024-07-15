package com.client.service;

import com.client.repository.ClientRepository;
import com.data.client.Client;
import com.data.client.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements iClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO addClient(Client client) {
        return new ClientDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO findClientByEmailAndPassword(String email, String password) {
        Optional<Client> client = clientRepository.findByEmailAndPassword(email, password);
        return client.map(ClientDTO::new).orElse(null);
    }

    @Override
    public ClientDTO findClientById(Long id_client) {
        Optional<Client> client = clientRepository.findById(id_client);
        return client.map(ClientDTO::new).orElse(null);
    }

}
