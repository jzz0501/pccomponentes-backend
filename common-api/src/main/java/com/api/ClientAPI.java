package com.api;

import com.data.client.Client;
import com.data.client.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "client-service", path = "/api/client", contextId = "client-service")
public interface ClientAPI {

    @PostMapping
    ClientDTO postClient(@RequestBody Client client);

    @GetMapping("/{id_client}")
    ClientDTO getClientById(@PathVariable(value = "id_client") Long id_client);

}