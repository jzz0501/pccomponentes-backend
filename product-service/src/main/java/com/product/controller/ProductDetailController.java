package com.product.controller;

import com.data.product.detail.ProductDetailDTO;
import com.product.service.product_detail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/product/detail")
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;

    @GetMapping("/{id_product}")
    public ProductDetailDTO getProductDetailById(@PathVariable("id_product") Long id_product) {
        return productDetailService.findProductDetailById(id_product);
    }

}