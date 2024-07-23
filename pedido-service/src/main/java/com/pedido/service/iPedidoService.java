package com.pedido.service;

import com.data.pedido.PedidoDTO;

public interface iPedidoService {

    PedidoDTO findPedidoById(Long id_pedido);

    PedidoDTO addPedido(Long id_client);

}