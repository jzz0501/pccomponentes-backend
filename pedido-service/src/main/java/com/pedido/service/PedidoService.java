package com.pedido.service;

import com.api.BasketAPI;
import com.api.ProductAPI;
import com.data.basket.BasketDTO;
import com.data.pedido.Pedido;
import com.data.pedido.PedidoDTO;
import com.data.pedido.PedidoDetail;
import com.data.pedido.PedidoDetailDTO;
import com.pedido.repository.PedidoDetailRepository;
import com.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements iPedidoService {

    @Autowired
    ProductAPI productAPI;

    @Autowired
    BasketAPI basketAPI;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoDetailRepository pedidoDetailRepository;

    @Override
    public PedidoDTO findPedidoById(Long id_pedido) {
        Optional<Pedido> pedido = pedidoRepository.findById(id_pedido);
        if(pedido.isEmpty()) {
            return null;
        }
        List<PedidoDetailDTO> pedidoDetailDTOList = pedidoDetailRepository
                                                        .findByPedidoId(id_pedido)
                                                        .stream()
                                                        .map(pedidoDetail -> new PedidoDetailDTO(pedidoDetail, productAPI.getProductById(pedidoDetail.getId_product())))
                                                        .toList();
        return new PedidoDTO(pedido.get(), pedidoDetailDTOList);
    }

    @Override
    public PedidoDTO addPedido(Long id_client) {
        Pedido pedido = new Pedido();
        List<BasketDTO> basketDTOList = basketAPI.getBasketByClientId(id_client);
        List<PedidoDetail> pedidoDetailList = new ArrayList<>();
        basketDTOList.forEach(basketDTO -> {
            PedidoDetail pedidoDetail = new PedidoDetail();
            pedidoDetail.setPedido(pedido);
            pedidoDetail.setId_product(basketDTO.getProduct().getId());
            pedidoDetail.setQuantity(basketDTO.getQuantity());
            pedidoDetail.setUnitPrice(basketDTO.getProduct().getPrice());
            pedidoDetailList.add(pedidoDetail);
        });
        pedido.setClientId(id_client);
        pedido.setCreatedDate(LocalDateTime.now().toString());

        Pedido pedidoSaved = pedidoRepository.save(pedido);
        List<PedidoDetail> pedidoDetailListSaved = pedidoDetailRepository.saveAll(pedidoDetailList);

        List<PedidoDetailDTO> pedidoDetailDTOList = pedidoDetailListSaved
                                                        .stream()
                                                        .map(pedidoDetail -> new PedidoDetailDTO(pedidoDetail, productAPI.getProductById(pedidoDetail.getId_product())))
                                                        .toList();

        return new PedidoDTO(pedidoSaved, pedidoDetailDTOList);
    }

}
