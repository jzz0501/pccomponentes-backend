package com.product.controller;

import com.data.product.ProductDTO;
import com.data.util.Pagination;
import com.product.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/pagination/match-name/{name}")
    public Pagination<ProductDTO> getProductPaginationByNameMatcher(@PathVariable("name") String name) {
        return productService.matchProductByNameWithPagination(name);
    }

    @GetMapping("/match-name/{name}")
    public List<ProductDTO> getProductByNameMatcher(@PathVariable("name") String name) {
        return productService.matchProductByName(name);
    }

}