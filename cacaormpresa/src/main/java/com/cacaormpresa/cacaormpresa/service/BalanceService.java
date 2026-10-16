package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.BalanceMasaDto;
import com.cacaormpresa.cacaormpresa.repository.*;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    private final LoteCacaoRepository loteRepository;
    private final ControlSecadoRepository controlSecadoRepository;
    private final PesajeGranosRepository pesajeGranosRepository;
    private final PesajePolvoRepository pesajePolvoRepository;
    private final PedidoVentaRepository pedidoRepository;

    public BalanceService(LoteCacaoRepository loteRepository,
                          ControlSecadoRepository controlSecadoRepository,
                          PesajeGranosRepository pesajeGranosRepository,
                          PesajePolvoRepository pesajePolvoRepository,
                          PedidoVentaRepository pedidoRepository) {
        this.loteRepository = loteRepository;
        this.controlSecadoRepository = controlSecadoRepository;
        this.pesajeGranosRepository = pesajeGranosRepository;
        this.pesajePolvoRepository = pesajePolvoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public BalanceMasaDto calcularBalanceIntegral() {
        Double totalCosechado = loteRepository.sumTotalPesoCosechadoKg();
        Double totalGranosSecos = pesajeGranosRepository.sumTotalGranosKg();
        Double totalMateriaPrimaProcesada = pesajePolvoRepository.sumTotalMateriaPrimaKg();
        Double totalPolvo = pesajePolvoRepository.sumTotalPolvoCacaoKg();
        Double totalManteca = pesajePolvoRepository.sumTotalMantecaKg();
        Double totalCascarilla = pesajePolvoRepository.sumTotalCascarillaMermaKg();
        Double totalExportado = pedidoRepository.sumTotalExportadoKg();

        // Mermas por evaporación de agua en secado (cacao en baba ~60% humedad se reduce a ~7% seco)
        // más mermas de cascarilla en descascarillado y molienda
        double mermaSecado = Math.max(0.0, totalCosechado - totalGranosSecos);
        double totalMermasPerdidas = mermaSecado + totalCascarilla;

        // Rendimiento físico global
        double rendimiento = (totalCosechado > 0)
                ? ((totalGranosSecos + totalPolvo + totalManteca) / (totalCosechado * 1.5)) * 100.0
                : 0.0;

        String verificacion = String.format(
                "Ecuación Física (HU-09/10): Total Cosechado (%.2f kg) = En Proceso/Almacén (%.2f kg) + Exportado (%.2f kg) + Mermas/Humedad (%.2f kg)",
                totalCosechado, (totalGranosSecos - totalExportado), totalExportado, totalMermasPerdidas
        );

        return new BalanceMasaDto(
                totalCosechado,
                totalGranosSecos,
                totalMateriaPrimaProcesada,
                totalPolvo,
                totalManteca,
                totalExportado,
                totalMermasPerdidas,
                Math.round(rendimiento * 100.0) / 100.0,
                verificacion
        );
    }
}
