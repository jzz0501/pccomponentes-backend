package com.product.service.product_sale;

import com.data.product.sale.ProductSale;
import com.data.product.sale.ProductSaleDTO;
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

    @Override
    public ProductSaleDTO addProductSaleStockById(Long id_product, Integer quantity) {
        return productSaleRepository
                .findById(id_product)
                .map(productSale -> {
                    productSale.setStock(productSale.getStock() + quantity);
                    return new ProductSaleDTO(productSaleRepository.save(productSale));
                })
                .orElse(null);
    }

    @Override
    public ProductSaleDTO addProductSaleSoldById(Long id_product, Integer quantity) {
        return productSaleRepository
                .findById(id_product)
                .map(productSale -> {
                    productSale.setStock(productSale.getStock() - quantity);
                    productSale.setSold(productSale.getSold() + quantity);
                    return new ProductSaleDTO(productSaleRepository.save(productSale));
                })
                .orElse(null);
    }
}