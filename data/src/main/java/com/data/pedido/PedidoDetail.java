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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "id_product")
    private Long id_product;

    @ManyToOne(targetEntity = Pedido.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedido pedido;

}