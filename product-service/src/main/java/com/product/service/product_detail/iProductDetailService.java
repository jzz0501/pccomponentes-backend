package com.product.service.product_detail;

import com.data.product.ProductDetailDTO;

public interface iProductDetailService {

    ProductDetailDTO findProductDetailById(Long id_product);

}