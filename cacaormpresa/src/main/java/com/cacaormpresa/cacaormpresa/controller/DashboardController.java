package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.DashboardSummaryDto;
import com.cacaormpresa.cacaormpresa.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@Tag(name = "14. Dashboard Gerencial y Reportes (RF-14)", description = "Métricas consolidadas y KPIs para gráficos interactivos (Chart.js)")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/resumen")
    @Operation(summary = "Obtener resumen gerencial de producción y ventas", description = "Provee todos los indicadores clave: volúmenes cosechados, procesados, exportados, stocks y ventas en USD")
    public ResponseEntity<DashboardSummaryDto> obtenerResumen() {
        return ResponseEntity.ok(dashboardService.obtenerResumenEjecutivo());
    }
}
