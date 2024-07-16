package com.basket.repository;

import com.data.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query("FROM Basket WHERE id_client = :id_client AND id_product = :id_product")
    Optional<Basket> findByClientIdAndProductId(@Param("id_client") Long id_client, @Param("id_product") Long id_product);

}