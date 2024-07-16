package com.basket.controller;

import com.basket.service.BasketService;
import com.data.basket.Basket;
import com.data.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping
    public BasketDTO addBasket(@RequestBody Basket basket) {
        return basketService.addBasket(basket);
    }

}