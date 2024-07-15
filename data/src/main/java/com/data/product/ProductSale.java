package com.data.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_sale")
public class ProductSale {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "stock")
    private Integer stock;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
