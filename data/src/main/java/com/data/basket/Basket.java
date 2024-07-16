package com.data.basket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_client")
    private Long id_client;

    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "quantity")
    private Integer quantity;

}