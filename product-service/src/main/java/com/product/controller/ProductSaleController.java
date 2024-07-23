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
    public ProductSaleDTO getProductSaleById(@PathVariable("id_product") Long id_product) {
        return productSaleService.findProductSaleById(id_product);
    }

    @PostMapping("/stock/{id_product}/{quantity}")
    public ProductSaleDTO postProductSaleStock(@PathVariable("id_product") Long id_product, @PathVariable("quantity") Integer quantity) {
        return productSaleService.addProductSaleStockById(id_product, quantity);
    }

    @PostMapping("/sold/{id_product}/{quantity}")
    public ProductSaleDTO postProductSaleSold(@PathVariable("id_product") Long id_product, @PathVariable("quantity") Integer quantity) {
        return productSaleService.addProductSaleSoldById(id_product, quantity);
    }

}
