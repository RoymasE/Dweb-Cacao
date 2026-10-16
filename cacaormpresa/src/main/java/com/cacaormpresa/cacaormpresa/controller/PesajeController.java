package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.PesajeGranosRequestDto;
import com.cacaormpresa.cacaormpresa.dto.PesajePolvoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionGranos;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionPolvo;
import com.cacaormpresa.cacaormpresa.service.PesajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesajes")
@Tag(name = "10. Contabilización de Pesos por Secciones (RF-09 / RF-10)", description = "Contabilización de peso en Sección 1 (Granos de cacao fermentados/secos) y Sección 2 (Polvo y derivados)")
public class PesajeController {

    private final PesajeService pesajeService;

    public PesajeController(PesajeService pesajeService) {
        this.pesajeService = pesajeService;
    }

    // ====== SECCIÓN 1: GRANOS ======

    @GetMapping("/seccion-1-granos")
    @Operation(summary = "Listar pesajes de Sección 1 (Granos secos)")
    public ResponseEntity<List<PesajeSeccionGranos>> listarPesajesGranos() {
        return ResponseEntity.ok(pesajeService.listarPesajesGranos());
    }

    @GetMapping("/seccion-1-granos/lote/{loteId}")
    @Operation(summary = "Obtener pesaje de granos por lote")
    public ResponseEntity<PesajeSeccionGranos> obtenerPesajeGranosPorLote(@PathVariable Long loteId) {
        return ResponseEntity.ok(pesajeService.obtenerPesajeGranosPorLote(loteId));
    }

    @PostMapping("/seccion-1-granos")
    @Operation(summary = "Registrar pesaje en Sección 1 (Granos secos)", description = "Calcula toneladas y sacos de 60 kg oficiales de exportación, y actualiza el stock disponible con ACID")
    public ResponseEntity<PesajeSeccionGranos> registrarPesajeGranos(@Valid @RequestBody PesajeGranosRequestDto dto) {
        PesajeSeccionGranos pesaje = pesajeService.registrarPesajeGranos(dto);
        return new ResponseEntity<>(pesaje, HttpStatus.CREATED);
    }

    // ====== SECCIÓN 2: POLVO Y DERIVADOS ======

    @GetMapping("/seccion-2-polvo")
    @Operation(summary = "Listar pesajes de Sección 2 (Polvo de cacao y derivados)")
    public ResponseEntity<List<PesajeSeccionPolvo>> listarPesajesPolvo() {
        return ResponseEntity.ok(pesajeService.listarPesajesPolvo());
    }

    @PostMapping("/seccion-2-polvo")
    @Operation(summary = "Registrar pesaje en Sección 2 (Polvo y derivados)", description = "Registra rendimiento de tostado, molienda y prensado (polvo, manteca y cascarilla merma)")
    public ResponseEntity<PesajeSeccionPolvo> registrarPesajePolvo(@Valid @RequestBody PesajePolvoRequestDto dto) {
        PesajeSeccionPolvo pesaje = pesajeService.registrarPesajePolvo(dto);
        return new ResponseEntity<>(pesaje, HttpStatus.CREATED);
    }
}
