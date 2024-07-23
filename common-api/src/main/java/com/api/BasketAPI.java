package com.api;

import com.data.basket.BasketDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "basket-service", path = "/api/basket", contextId = "basket-service")
public interface BasketAPI {

    @GetMapping("/client/{id_client}")
    List<BasketDTO> getBasketByClientId(@PathVariable("id_client") Long id_client);

}