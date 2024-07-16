package com.data.basket;

import com.data.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketDTO {

    private Long id;

    private ProductDTO product;

    private Integer quantity;

    public BasketDTO(Basket basket, ProductDTO product) {
        this.id = basket.getId();
        this.product = product;
        this.quantity = basket.getQuantity();
    }

}