package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.BalanceMasaDto;
import com.cacaormpresa.cacaormpresa.service.BalanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balance")
@Tag(name = "13. Balance Integral de Masas (RF-11)", description = "Cálculo automatizado del balance de volúmenes: Cosechado = Procesado + Exportado + Perdido (Mermas)")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/integral")
    @Operation(summary = "Calcular balance integral de masas", description = "Verifica la correlación física del flujo productivo desde el cacao en baba hasta la exportación y mermas")
    public ResponseEntity<BalanceMasaDto> obtenerBalanceIntegral() {
        return ResponseEntity.ok(balanceService.calcularBalanceIntegral());
    }
}
