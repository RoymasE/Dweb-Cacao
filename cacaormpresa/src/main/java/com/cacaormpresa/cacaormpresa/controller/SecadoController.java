package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.SecadoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.ControlSecado;
import com.cacaormpresa.cacaormpresa.service.SecadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secado")
@Tag(name = "9. Control de Secado y Medición de Humedad (RF-08)", description = "Monitoreo del tendido en secadores solares hasta alcanzar ~7% de humedad")
public class SecadoController {

    private final SecadoService secadoService;

    public SecadoController(SecadoService secadoService) {
        this.secadoService = secadoService;
    }

    @GetMapping
    @Operation(summary = "Listar controles de secado")
    public ResponseEntity<List<ControlSecado>> listarTodos() {
        return ResponseEntity.ok(secadoService.listarTodos());
    }

    @GetMapping("/lote/{loteId}")
    @Operation(summary = "Obtener control de secado por ID de lote")
    public ResponseEntity<ControlSecado> obtenerPorLote(@PathVariable Long loteId) {
        return ResponseEntity.ok(secadoService.obtenerPorLote(loteId));
    }

    @PostMapping("/control")
    @Operation(summary = "Registrar o actualizar control de secado", description = "Registra humedad final (%) y peso seco. Valida que el lote haya completado fermentación previa")
    public ResponseEntity<ControlSecado> registrarSecado(@Valid @RequestBody SecadoRequestDto dto) {
        ControlSecado secado = secadoService.registrarSecado(dto);
        return new ResponseEntity<>(secado, HttpStatus.CREATED);
    }
}
