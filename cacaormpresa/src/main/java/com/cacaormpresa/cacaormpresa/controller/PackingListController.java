package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.PackingListRequestDto;
import com.cacaormpresa.cacaormpresa.entity.PackingList;
import com.cacaormpresa.cacaormpresa.service.PackingListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packing-list")
@Tag(name = "12. Control de Despacho y Lista de Empaque (RF-13)", description = "Generación del Packing List oficial de sacos y lotes para exportación marítima")
public class PackingListController {

    private final PackingListService packingListService;

    public PackingListController(PackingListService packingListService) {
        this.packingListService = packingListService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los Packing Lists")
    public ResponseEntity<List<PackingList>> listarTodos() {
        return ResponseEntity.ok(packingListService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Packing List por ID")
    public ResponseEntity<PackingList> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(packingListService.obtenerPorId(id));
    }

    @GetMapping("/pedido/{pedidoId}")
    @Operation(summary = "Obtener Packing List por ID del pedido de venta")
    public ResponseEntity<PackingList> obtenerPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(packingListService.obtenerPorPedido(pedidoId));
    }

    @PostMapping
    @Operation(summary = "Generar Packing List oficial de exportación marítima", description = "Asocia el pedido, naviera, contenedor, número de sacos de yute y cambia estado del pedido a DESPACHADO")
    public ResponseEntity<PackingList> generar(@Valid @RequestBody PackingListRequestDto dto) {
        PackingList packing = packingListService.generarPackingList(dto);
        return new ResponseEntity<>(packing, HttpStatus.CREATED);
    }
}
