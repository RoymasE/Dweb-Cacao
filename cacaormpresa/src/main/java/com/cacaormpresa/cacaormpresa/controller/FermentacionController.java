package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.FermentacionRequestDto;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.entity.MonitoreoFermentacion;
import com.cacaormpresa.cacaormpresa.service.FermentacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fermentacion")
@Tag(name = "8. Monitoreo Técnico de Fermentación (RF-07)", description = "Control diario en cajones (4-6 días), control de volteos, temperatura en °C y alertas semafóricas (45°C - 50°C)")
public class FermentacionController {

    private final FermentacionService fermentacionService;

    public FermentacionController(FermentacionService fermentacionService) {
        this.fermentacionService = fermentacionService;
    }

    @GetMapping("/lote/{loteId}")
    @Operation(summary = "Obtener historial de monitoreo de fermentación por lote")
    public ResponseEntity<List<MonitoreoFermentacion>> listarPorLote(@PathVariable Long loteId) {
        return ResponseEntity.ok(fermentacionService.listarPorLote(loteId));
    }

    @GetMapping("/alertas")
    @Operation(summary = "Listar alertas de temperatura fuera de rango normado (45°C - 50°C)")
    public ResponseEntity<List<MonitoreoFermentacion>> listarAlertas() {
        return ResponseEntity.ok(fermentacionService.listarAlertasTemperatura());
    }

    @PostMapping("/monitoreo")
    @Operation(summary = "Registrar monitoreo diario de fermentación", description = "Guarda día, temperatura y volteo. Emite alerta automática si temp < 45°C o > 50°C")
    public ResponseEntity<MonitoreoFermentacion> registrarMonitoreo(@Valid @RequestBody FermentacionRequestDto dto) {
        MonitoreoFermentacion monitoreo = fermentacionService.registrarMonitoreoDiario(dto);
        return new ResponseEntity<>(monitoreo, HttpStatus.CREATED);
    }

    @PostMapping("/completar/{loteId}")
    @Operation(summary = "Completar etapa de fermentación", description = "Valida que el lote cuente con al menos 4 días de control técnico antes de autorizar el paso a secado")
    public ResponseEntity<LoteCacao> completarFermentacion(@PathVariable Long loteId) {
        LoteCacao lote = fermentacionService.completarFermentacion(loteId);
        return ResponseEntity.ok(lote);
    }
}
