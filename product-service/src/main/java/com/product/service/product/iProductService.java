package com.product.service.product;

import com.data.product.ProductDTO;
import com.data.util.Pagination;

public interface iProductService {

    ProductDTO findProductById(Long id_product);

    Pagination<ProductDTO> findAllProductWithPagination();

}