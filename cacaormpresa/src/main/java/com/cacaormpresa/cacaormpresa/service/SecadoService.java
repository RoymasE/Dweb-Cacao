package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.SecadoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.ControlSecado;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.ControlSecadoRepository;
import com.cacaormpresa.cacaormpresa.repository.LoteCacaoRepository;
import com.cacaormpresa.cacaormpresa.repository.MonitoreoFermentacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecadoService {

    private final ControlSecadoRepository controlSecadoRepository;
    private final LoteCacaoRepository loteRepository;
    private final MonitoreoFermentacionRepository monitoreoRepository;

    public SecadoService(ControlSecadoRepository controlSecadoRepository,
                         LoteCacaoRepository loteRepository,
                         MonitoreoFermentacionRepository monitoreoRepository) {
        this.controlSecadoRepository = controlSecadoRepository;
        this.loteRepository = loteRepository;
        this.monitoreoRepository = monitoreoRepository;
    }

    public List<ControlSecado> listarTodos() {
        return controlSecadoRepository.findAll();
    }

    public ControlSecado obtenerPorLote(Long loteId) {
        return controlSecadoRepository.findByLoteId(loteId)
                .orElseThrow(() -> new ResourceNotFoundException("Control de secado no encontrado para lote con ID: " + loteId));
    }

    @Transactional
    public ControlSecado registrarSecado(SecadoRequestDto dto) {
        LoteCacao lote = loteRepository.findById(dto.getLoteId())
                .orElseThrow(() -> new ResourceNotFoundException("Lote no encontrado con ID: " + dto.getLoteId()));

        long diasFermentados = monitoreoRepository.countByLoteId(dto.getLoteId());
        if (diasFermentados < 4 && lote.getEstado() != LoteCacao.EstadoLote.FERMENTADO) {
            throw new BusinessException("Restricción (HU-06/07): No se permite enviar un lote a secado sin haber " +
                    "completado el periodo de fermentación (mínimo 4 días de control registrados).");
        }

        ControlSecado secado = controlSecadoRepository.findByLoteId(dto.getLoteId())
                .orElse(new ControlSecado());

        secado.setLote(lote);
        secado.setFechaInicio(dto.getFechaInicio());
        secado.setFechaFin(dto.getFechaFin());
        secado.setHumedadPorcentaje(dto.getHumedadPorcentaje());
        secado.setPesoSecoKg(dto.getPesoSecoKg());
        secado.setDiasSecado(dto.getDiasSecado());
        secado.setObservaciones(dto.getObservaciones());
        secado.setHumedadOptimaAlcanzada(dto.getHumedadPorcentaje() <= 7.5);

        if (secado.getHumedadOptimaAlcanzada()) {
            lote.setEstado(LoteCacao.EstadoLote.SECADO_COMPLETO);
        } else {
            lote.setEstado(LoteCacao.EstadoLote.EN_SECADO);
        }
        loteRepository.save(lote);

        return controlSecadoRepository.save(secado);
    }
}
