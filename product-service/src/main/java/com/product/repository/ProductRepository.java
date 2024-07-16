package com.product.repository;

import com.data.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product WHERE name LIKE %:name%")
    List<Product> matchByName(@Param(value = "name") String name);

    @Query("FROM Product WHERE name LIKE %:name%")
    Page<Product> matchByName(@Param(value = "name") String name, Pageable pageable);

}
