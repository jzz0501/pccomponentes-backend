package com.api;

import com.data.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service", path = "/api/product", contextId = "product-service")
public interface ProductAPI {

    @GetMapping("/{id_product}")
    ProductDTO getProductById(@PathVariable("id_product") Long id_product);

}
