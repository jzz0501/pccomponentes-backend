package com.data.pedido;

import com.data.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetailDTO {

    private BigDecimal unitPrice;

    private Integer quantity;

    private ProductDTO product;

    public PedidoDetailDTO(PedidoDetail pedidoDetail, ProductDTO productDTO) {
        this.unitPrice = pedidoDetail.getUnitPrice();
        this.quantity = pedidoDetail.getQuantity();
        this.product = productDTO;
    }

}