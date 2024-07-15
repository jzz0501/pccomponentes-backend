package com.product.controller;

import com.data.product.ProductDTO;
import com.data.util.Pagination;
import com.product.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id_product}")
    public ProductDTO getProductById(@PathVariable("id_product") Long id_product) {
        return productService.findProductById(id_product);
    }

    @GetMapping("/page")
    public Pagination<ProductDTO> getPage() {
        return productService.findAllProductWithPagination();
    }

}