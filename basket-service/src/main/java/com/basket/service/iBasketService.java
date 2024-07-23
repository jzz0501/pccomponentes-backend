package com.basket.service;

import com.data.basket.Basket;
import com.data.basket.BasketDTO;

import java.util.List;

public interface iBasketService {

    BasketDTO addBasket(Basket basket);

    List<BasketDTO> findBasketById(Long id_client);

    void removeBasketById(Long id_basket);

}