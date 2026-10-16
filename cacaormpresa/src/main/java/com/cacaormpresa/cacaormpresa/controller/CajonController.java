package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.entity.CajonFermentacion;
import com.cacaormpresa.cacaormpresa.service.CajonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajones")
@Tag(name = "6. Catálogo de Cajones de Madera (RF-06)", description = "Control de cajas de madera para fermentación de cacao")
public class CajonController {

    private final CajonService cajonService;

    public CajonController(CajonService cajonService) {
        this.cajonService = cajonService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los cajones")
    public ResponseEntity<List<CajonFermentacion>> listarTodos() {
        return ResponseEntity.ok(cajonService.listarTodos());
    }

    @GetMapping("/disponibles")
    @Operation(summary = "Listar cajones disponibles")
    public ResponseEntity<List<CajonFermentacion>> listarDisponibles() {
        return ResponseEntity.ok(cajonService.listarDisponibles());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cajón por ID")
    public ResponseEntity<CajonFermentacion> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cajonService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Registrar nuevo cajón de fermentación")
    public ResponseEntity<CajonFermentacion> crear(@RequestBody CajonFermentacion cajon) {
        return new ResponseEntity<>(cajonService.crear(cajon), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/estado")
    @Operation(summary = "Cambiar estado de cajón (DISPONIBLE, EN_FERMENTACION, MANTENIMIENTO)")
    public ResponseEntity<CajonFermentacion> cambiarEstado(@PathVariable Long id, @RequestParam CajonFermentacion.EstadoCajon estado) {
        return ResponseEntity.ok(cajonService.actualizarEstado(id, estado));
    }
}
