package com.client.controller;

import com.client.service.ClientService;
import com.data.client.Client;
import com.data.client.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ClientDTO postClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @GetMapping("/{id_client}")
    public ClientDTO getClientById(@PathVariable(value = "id_client") Long id_client) {
        return clientService.findClientById(id_client);
    }

    @GetMapping
    public ClientDTO getClientByEmailAndPassword(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        return clientService.findClientByEmailAndPassword(email, password);
    }

}
