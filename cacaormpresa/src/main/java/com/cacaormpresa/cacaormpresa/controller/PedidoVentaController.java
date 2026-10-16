package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.PedidoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import com.cacaormpresa.cacaormpresa.service.PedidoVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "11. Gestión de Pedidos y Ventas Internacionales (RF-12)", description = "Recepción de solicitudes de clientes extranjeros, reserva por sección y confirmación comercial con restricción de stock")
public class PedidoVentaController {

    private final PedidoVentaService pedidoService;

    public PedidoVentaController(PedidoVentaService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los pedidos de venta")
    public ResponseEntity<List<PedidoVenta>> listarTodos(@RequestParam(required = false) PedidoVenta.EstadoPedido estado) {
        if (estado != null) {
            return ResponseEntity.ok(pedidoService.listarPorEstado(estado));
        }
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido de venta por ID")
    public ResponseEntity<PedidoVenta> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Registrar nuevo pedido de venta internacional", description = "Valida que exista stock suficiente en la sección seleccionada (Sección 1 Granos o Sección 2 Polvo)")
    public ResponseEntity<PedidoVenta> crearPedido(@Valid @RequestBody PedidoRequestDto dto) {
        PedidoVenta pedido = pedidoService.crearPedido(dto);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/confirmar")
    @Operation(summary = "Confirmar venta y reservar stock", description = "Aplica bloqueo transaccional ACID descontando el inventario disponible de la sección seleccionada")
    public ResponseEntity<PedidoVenta> confirmarPedido(@PathVariable Long id) {
        PedidoVenta pedido = pedidoService.confirmarPedido(id);
        return ResponseEntity.ok(pedido);
    }
}
