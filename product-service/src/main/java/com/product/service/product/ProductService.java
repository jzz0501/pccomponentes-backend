package com.product.service.product;

import com.data.product.Product;
import com.data.product.ProductDTO;
import com.data.util.Pagination;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements iProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO findProductById(Long id_product) {
        Optional<Product> product = productRepository.findById(id_product);
        return product.map(ProductDTO::new).orElse(null);
    }

    @Override
    public Pagination<ProductDTO> findAllProductWithPagination() {
        Page<ProductDTO> productDTOS = productRepository.findAll(PageRequest.of(0,10)).map(ProductDTO::new);
        return new Pagination<>(productDTOS);
    }
}