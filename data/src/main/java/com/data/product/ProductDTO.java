package com.data.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String slug;

    private String name;

    private BigDecimal price;

    private BigDecimal lowestPrice;

    private String webURL;

    private String imageURL;

    private BigDecimal discount;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.slug = product.getSlug();
        this.name = product.getName();
        this.price = product.getPrice();
        this.lowestPrice = product.getLowestPrice();
        this.webURL = product.getWebURL();
        this.imageURL = product.getImageURL();
        this.discount = product.getDiscount();
    }

}