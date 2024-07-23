package com.pedido.controller;

import com.data.pedido.PedidoDTO;
import com.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/{id_pedido}")
    public PedidoDTO getPedidoById(@PathVariable("id_pedido") Long id_pedido) {
        return pedidoService.findPedidoById(id_pedido);
    }

    @PostMapping("/{id_client}")
    public PedidoDTO postPedido(@PathVariable("id_client") Long id_client) {
        return pedidoService.addPedido(id_client);
    }

}
