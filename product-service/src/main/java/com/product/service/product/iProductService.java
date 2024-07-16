package com.product.service.product;

import com.data.product.ProductDTO;
import com.data.util.Pagination;

import java.util.List;

public interface iProductService {

    ProductDTO findProductById(Long id_product);

    List<ProductDTO> matchProductByName(String name);

    Pagination<ProductDTO> matchProductByNameWithPagination(String name);

}