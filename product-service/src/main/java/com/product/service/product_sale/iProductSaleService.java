package com.product.service.product_sale;

import com.data.product.sale.ProductSaleDTO;

public interface iProductSaleService {

    ProductSaleDTO findProductSaleById(Long id_product);

}