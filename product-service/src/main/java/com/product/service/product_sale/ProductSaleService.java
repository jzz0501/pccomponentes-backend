package com.product.service.product_sale;

import com.data.product.ProductSaleDTO;
import com.product.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSaleService implements iProductSaleService {

    @Autowired
    ProductSaleRepository productSaleRepository;

    @Override
    public ProductSaleDTO findProductSaleById(Long id_product) {
        return productSaleRepository
                .findById(id_product)
                .map(ProductSaleDTO::new)
                .orElse(null);
    }
}