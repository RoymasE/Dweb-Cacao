package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.DashboardSummaryDto;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import com.cacaormpresa.cacaormpresa.repository.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final LoteCacaoRepository loteRepository;
    private final PesajeGranosRepository pesajeGranosRepository;
    private final PesajePolvoRepository pesajePolvoRepository;
    private final PedidoVentaRepository pedidoRepository;
    private final MonitoreoFermentacionRepository monitoreoRepository;

    public DashboardService(LoteCacaoRepository loteRepository,
                            PesajeGranosRepository pesajeGranosRepository,
                            PesajePolvoRepository pesajePolvoRepository,
                            PedidoVentaRepository pedidoRepository,
                            MonitoreoFermentacionRepository monitoreoRepository) {
        this.loteRepository = loteRepository;
        this.pesajeGranosRepository = pesajeGranosRepository;
        this.pesajePolvoRepository = pesajePolvoRepository;
        this.pedidoRepository = pedidoRepository;
        this.monitoreoRepository = monitoreoRepository;
    }

    public DashboardSummaryDto obtenerResumenEjecutivo() {
        DashboardSummaryDto dto = new DashboardSummaryDto();

        dto.setTotalCosechadoKg(loteRepository.sumTotalPesoCosechadoKg());
        dto.setTotalGranosSecosKg(pesajeGranosRepository.sumTotalGranosKg());
        dto.setStockDisponibleGranosKg(pesajeGranosRepository.sumStockDisponibleGranosKg());
        dto.setTotalPolvoCacaoKg(pesajePolvoRepository.sumTotalPolvoCacaoKg());
        dto.setStockDisponiblePolvoKg(pesajePolvoRepository.sumStockDisponiblePolvoKg());
        dto.setTotalExportadoKg(pedidoRepository.sumTotalExportadoKg());
        dto.setTotalVentasUsd(pedidoRepository.sumTotalVentasUsd());

        dto.setLotesEnFermentacion((long) loteRepository.findByEstado(LoteCacao.EstadoLote.EN_FERMENTACION).size());
        dto.setLotesEnSecado((long) loteRepository.findByEstado(LoteCacao.EstadoLote.EN_SECADO).size());
        dto.setPedidosPendientes((long) pedidoRepository.findByEstadoPedido(PedidoVenta.EstadoPedido.PENDIENTE).size());
        dto.setAlertasTemperaturaActivas((long) monitoreoRepository.findByAlertaTemperaturaTrue().size());

        // Distribución por variedad de cacao
        Map<String, Double> variedadMap = new HashMap<>();
        List<LoteCacao> lotes = loteRepository.findAll();
        for (LoteCacao l : lotes) {
            variedadMap.merge(l.getVariedad(), l.getPesoBabaKg(), Double::sum);
        }
        dto.setDistribucionPorVariedad(variedadMap);

        // Exportaciones por país de destino
        Map<String, Double> paisMap = new HashMap<>();
        List<PedidoVenta> pedidos = pedidoRepository.findAll();
        for (PedidoVenta p : pedidos) {
            if (p.getCliente() != null && p.getCliente().getPaisDestino() != null) {
                paisMap.merge(p.getCliente().getPaisDestino(), p.getCantidadKg(), Double::sum);
            }
        }
        dto.setExportacionesPorPais(paisMap);

        return dto;
    }
}
