package com.pedido.repository;

import com.data.pedido.PedidoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDetailRepository extends JpaRepository<PedidoDetail, Long> {

    @Query("FROM PedidoDetail WHERE pedido.id = :id_pedido")
    List<PedidoDetail> findByPedidoId(@Param(value = "id_pedido") Long id_pedido);

}