package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.LoteRequestDto;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.service.CosechaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cosecha")
@Tag(name = "7. Recepción de Cosecha y Lotes de Cacao (RF-06)", description = "Registro de cacao en baba ingresado y apertura de lotes de trazabilidad")
public class CosechaController {

    private final CosechaService cosechaService;

    public CosechaController(CosechaService cosechaService) {
        this.cosechaService = cosechaService;
    }

    @GetMapping("/lotes")
    @Operation(summary = "Listar todos los lotes de cacao")
    public ResponseEntity<List<LoteCacao>> listarLotes(@RequestParam(required = false) LoteCacao.EstadoLote estado) {
        if (estado != null) {
            return ResponseEntity.ok(cosechaService.listarPorEstado(estado));
        }
        return ResponseEntity.ok(cosechaService.listarTodos());
    }

    @GetMapping("/lotes/{id}")
    @Operation(summary = "Obtener lote por ID")
    public ResponseEntity<LoteCacao> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cosechaService.obtenerPorId(id));
    }

    @GetMapping("/lotes/codigo/{codigo}")
    @Operation(summary = "Obtener lote por código oficial")
    public ResponseEntity<LoteCacao> obtenerPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(cosechaService.obtenerPorCodigo(codigo));
    }

    @PostMapping("/lotes")
    @Operation(summary = "Registrar recepción de cosecha de cacao en baba", description = "Crea un lote de cacao con peso en baba y asigna un cajón de madera")
    public ResponseEntity<LoteCacao> registrarCosecha(@Valid @RequestBody LoteRequestDto dto) {
        LoteCacao lote = cosechaService.registrarCosechaBaba(dto);
        return new ResponseEntity<>(lote, HttpStatus.CREATED);
    }
}
