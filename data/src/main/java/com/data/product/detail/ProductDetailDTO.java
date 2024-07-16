package com.data.product.detail;

import com.data.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO extends ProductDTO {

    private ProductDetailContextData contextData;

    public ProductDetailDTO(ProductDetail productDetail) {
        super(productDetail.getProduct());
        this.contextData = new ProductDetailContextData(productDetail.getAbout(), productDetail.getSpecifications());
    }

}
