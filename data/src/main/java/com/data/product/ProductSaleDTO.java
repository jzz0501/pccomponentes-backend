package com.data.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleDTO extends ProductDTO {

    private ProductSaleContextData contextData;

    public ProductSaleDTO(ProductSale productSale) {
        super(productSale.getProduct());
        this.contextData = new ProductSaleContextData(productSale.getStock(), productSale.getSold());
    }

}
