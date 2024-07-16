package com.product.controller;

import com.data.product.sale.ProductSaleDTO;
import com.product.service.product_sale.ProductSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/product/sale")
public class ProductSaleController {

    @Autowired
    ProductSaleService productSaleService;

    @GetMapping("/{id_product}")
    public ProductSaleDTO getProductDetailById(@PathVariable("id_product") Long id_product) {
        return productSaleService.findProductSaleById(id_product);
    }

}
