package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.FermentacionRequestDto;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.entity.MonitoreoFermentacion;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.LoteCacaoRepository;
import com.cacaormpresa.cacaormpresa.repository.MonitoreoFermentacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FermentacionService {

    private final MonitoreoFermentacionRepository monitoreoRepository;
    private final LoteCacaoRepository loteRepository;

    public FermentacionService(MonitoreoFermentacionRepository monitoreoRepository,
                               LoteCacaoRepository loteRepository) {
        this.monitoreoRepository = monitoreoRepository;
        this.loteRepository = loteRepository;
    }

    public List<MonitoreoFermentacion> listarPorLote(Long loteId) {
        return monitoreoRepository.findByLoteIdOrderByDiaNumeroAsc(loteId);
    }

    public List<MonitoreoFermentacion> listarAlertasTemperatura() {
        return monitoreoRepository.findByAlertaTemperaturaTrue();
    }

    @Transactional
    public MonitoreoFermentacion registrarMonitoreoDiario(FermentacionRequestDto dto) {
        LoteCacao lote = loteRepository.findById(dto.getLoteId())
                .orElseThrow(() -> new ResourceNotFoundException("Lote de cacao no encontrado con ID: " + dto.getLoteId()));

        if (lote.getEstado() == LoteCacao.EstadoLote.FINALIZADO ||
            lote.getEstado() == LoteCacao.EstadoLote.EN_SECADO ||
            lote.getEstado() == LoteCacao.EstadoLote.SECADO_COMPLETO) {
            throw new BusinessException("El lote ya completó o superó la etapa de fermentación");
        }

        lote.setEstado(LoteCacao.EstadoLote.EN_FERMENTACION);
        loteRepository.save(lote);

        MonitoreoFermentacion monitoreo = new MonitoreoFermentacion(
                lote,
                dto.getDiaNumero(),
                dto.getFechaRegistro(),
                dto.getTemperaturaCelsius(),
                dto.getVolteoRealizado(),
                dto.getObservaciones()
        );

        return monitoreoRepository.save(monitoreo);
    }

    @Transactional
    public LoteCacao completarFermentacion(Long loteId) {
        LoteCacao lote = loteRepository.findById(loteId)
                .orElseThrow(() -> new ResourceNotFoundException("Lote no encontrado"));

        long registros = monitoreoRepository.countByLoteId(loteId);
        if (registros < 4) {
            throw new BusinessException("Restricción Técnica (RF-07): Se requieren mínimo 4 días de control " +
                    "de fermentación para pasar el lote a secado (días registrados: " + registros + ")");
        }

        lote.setEstado(LoteCacao.EstadoLote.FERMENTADO);
        return loteRepository.save(lote);
    }
}
