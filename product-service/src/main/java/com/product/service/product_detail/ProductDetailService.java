package com.product.service.product_detail;

import com.data.product.ProductDetail;
import com.data.product.ProductDetailDTO;
import com.product.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailService implements iProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetailDTO findProductDetailById(Long id_product) {
        Optional<ProductDetail> productDetailOptional = productDetailRepository.findById(id_product);
        return productDetailOptional.map(ProductDetailDTO::new).orElse(null);
    }

}