package com.data.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_detail")
public class PedidoDetail {

    @Id
    @Column(name = "pedido_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_id")
    private Long productId;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

}