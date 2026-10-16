package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.entity.AreaPlanta;
import com.cacaormpresa.cacaormpresa.service.AreaPlantaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@Tag(name = "3. Catálogo de Parámetros Base - Áreas (RF-03)", description = "Administración de áreas operativas de la agroindustria")
public class AreaPlantaController {

    private final AreaPlantaService areaPlantaService;

    public AreaPlantaController(AreaPlantaService areaPlantaService) {
        this.areaPlantaService = areaPlantaService;
    }

    @GetMapping
    @Operation(summary = "Listar áreas de planta")
    public ResponseEntity<List<AreaPlanta>> listarTodas() {
        return ResponseEntity.ok(areaPlantaService.listarTodas());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    @Operation(summary = "Registrar nueva área operativa")
    public ResponseEntity<AreaPlanta> crear(@RequestBody AreaPlanta area) {
        return new ResponseEntity<>(areaPlantaService.guardar(area), HttpStatus.CREATED);
    }
}
