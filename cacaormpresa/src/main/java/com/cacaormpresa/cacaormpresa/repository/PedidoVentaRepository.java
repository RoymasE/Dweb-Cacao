package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoVentaRepository extends JpaRepository<PedidoVenta, Long> {
    Optional<PedidoVenta> findByNumeroPedido(String numeroPedido);
    List<PedidoVenta> findByEstadoPedido(PedidoVenta.EstadoPedido estadoPedido);
    List<PedidoVenta> findByClienteId(Long clienteId);

    @Query("SELECT COALESCE(SUM(p.cantidadKg), 0.0) FROM PedidoVenta p WHERE p.estadoPedido = 'DESPACHADO'")
    Double sumTotalExportadoKg();

    @Query("SELECT COALESCE(SUM(p.totalUsd), 0.0) FROM PedidoVenta p WHERE p.estadoPedido IN ('CONFIRMADO', 'DESPACHADO')")
    Double sumTotalVentasUsd();
}
