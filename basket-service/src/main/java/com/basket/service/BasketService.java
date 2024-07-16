package com.basket.service;

import com.api.ClientAPI;
import com.api.ProductAPI;
import com.basket.repository.BasketRepository;
import com.data.basket.Basket;
import com.data.basket.BasketDTO;
import com.data.client.ClientDTO;
import com.data.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService implements iBasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductAPI productAPI;

    @Autowired
    ClientAPI clientAPI;

    @Override
    public BasketDTO addBasket(Basket basket) {

        ProductDTO productDTO = productAPI.getProductById(basket.getId_product());
        ClientDTO clientDTO = clientAPI.getClientById(basket.getId_client());
        if(productDTO == null || clientDTO == null) {
            return null;
        }

        Optional<Basket> optionalBasket = basketRepository.findByClientIdAndProductId(basket.getId_client(), basket.getId_product());
        Basket savedBasket = optionalBasket.map((currentBasket) -> {
            currentBasket.setQuantity(currentBasket.getQuantity() + basket.getQuantity());
            return basketRepository.save(currentBasket);
        }).orElse(basketRepository.save(new Basket(basket.getId(), basket.getId_client(), basket.getId_product(), basket.getQuantity())));

        return new BasketDTO(savedBasket, productDTO);
    }

}