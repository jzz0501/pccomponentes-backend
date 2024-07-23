package com.basket.controller;

import com.basket.service.BasketService;
import com.data.basket.Basket;
import com.data.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("/client/{id_client}")
    public List<BasketDTO> getBasketByClientId(@PathVariable("id_client") Long id_client) {
        return basketService.findBasketById(id_client);
    }

    @PostMapping
    public BasketDTO postBasket(@RequestBody Basket basket) {
        return basketService.addBasket(basket);
    }

    @DeleteMapping("/{id_client}")
    public void deleteBasketById(@PathVariable("id_client") Long id_client) {
        basketService.removeBasketById(id_client);
    }

}