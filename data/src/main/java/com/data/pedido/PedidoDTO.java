package com.data.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    private String createdDate;

    private List<PedidoDetailDTO> products;

    public PedidoDTO(Pedido pedido, List<PedidoDetailDTO> pedidoDetailDTOList) {
        this.id = pedido.getId();
        this.createdDate = pedido.getCreatedDate();
        this.products = pedidoDetailDTOList;
    }

}