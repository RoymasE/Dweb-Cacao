package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.PesajeGranosRequestDto;
import com.cacaormpresa.cacaormpresa.dto.PesajePolvoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionGranos;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionPolvo;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.LoteCacaoRepository;
import com.cacaormpresa.cacaormpresa.repository.PesajeGranosRepository;
import com.cacaormpresa.cacaormpresa.repository.PesajePolvoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PesajeService {

    private final PesajeGranosRepository pesajeGranosRepository;
    private final PesajePolvoRepository pesajePolvoRepository;
    private final LoteCacaoRepository loteRepository;

    public PesajeService(PesajeGranosRepository pesajeGranosRepository,
                         PesajePolvoRepository pesajePolvoRepository,
                         LoteCacaoRepository loteRepository) {
        this.pesajeGranosRepository = pesajeGranosRepository;
        this.pesajePolvoRepository = pesajePolvoRepository;
        this.loteRepository = loteRepository;
    }

    // ====== SECCIÓN 1: GRANOS FERMENTADOS Y SECOS ======

    public List<PesajeSeccionGranos> listarPesajesGranos() {
        return pesajeGranosRepository.findAll();
    }

    public PesajeSeccionGranos obtenerPesajeGranosPorLote(Long loteId) {
        return pesajeGranosRepository.findByLoteId(loteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pesaje de granos no encontrado para lote ID: " + loteId));
    }

    @Transactional
    public PesajeSeccionGranos registrarPesajeGranos(PesajeGranosRequestDto dto) {
        LoteCacao lote = loteRepository.findById(dto.getLoteId())
                .orElseThrow(() -> new ResourceNotFoundException("Lote no encontrado con ID: " + dto.getLoteId()));

        if (pesajeGranosRepository.findByLoteId(dto.getLoteId()).isPresent()) {
            throw new BusinessException("El lote ID " + dto.getLoteId() + " ya tiene un registro de pesaje en Sección 1");
        }

        PesajeSeccionGranos pesaje = new PesajeSeccionGranos(
                lote,
                dto.getFechaPesaje(),
                dto.getPesoGranosKg(),
                dto.getCalidadGrado(),
                dto.getObservaciones()
        );

        lote.setEstado(LoteCacao.EstadoLote.EN_ALMACEN_GRANOS);
        loteRepository.save(lote);

        return pesajeGranosRepository.save(pesaje);
    }

    // ====== SECCIÓN 2: POLVO DE CACAO Y DERIVADOS ======

    public List<PesajeSeccionPolvo> listarPesajesPolvo() {
        return pesajePolvoRepository.findAll();
    }

    public List<PesajeSeccionPolvo> listarPesajesPolvoPorLote(Long loteId) {
        return pesajePolvoRepository.findByLoteOrigenId(loteId);
    }

    @Transactional
    public PesajeSeccionPolvo registrarPesajePolvo(PesajePolvoRequestDto dto) {
        LoteCacao loteOrigen = loteRepository.findById(dto.getLoteOrigenId())
                .orElseThrow(() -> new ResourceNotFoundException("Lote de origen no encontrado con ID: " + dto.getLoteOrigenId()));

        // Descontar materia prima del stock de granos si corresponde (transacción ACID)
        PesajeSeccionGranos pesajeGranos = pesajeGranosRepository.findByLoteId(dto.getLoteOrigenId()).orElse(null);
        if (pesajeGranos != null) {
            if (pesajeGranos.getStockDisponibleKg() < dto.getPesoMateriaPrimaKg()) {
                throw new BusinessException("Stock insuficiente en Sección 1 para procesar molienda. Stock disponible: "
                        + pesajeGranos.getStockDisponibleKg() + " kg, requerido: " + dto.getPesoMateriaPrimaKg() + " kg");
            }
            pesajeGranos.setStockDisponibleKg(pesajeGranos.getStockDisponibleKg() - dto.getPesoMateriaPrimaKg());
            pesajeGranosRepository.save(pesajeGranos);
        }

        PesajeSeccionPolvo pesajePolvo = new PesajeSeccionPolvo(
                loteOrigen,
                dto.getFechaProcesamiento(),
                dto.getPesoMateriaPrimaKg(),
                dto.getPesoPolvoCacaoKg(),
                dto.getPesoMantecaCacaoKg(),
                dto.getPesoCascarillaMermaKg(),
                dto.getObservaciones()
        );

        loteOrigen.setEstado(LoteCacao.EstadoLote.EN_PROCESAMIENTO);
        loteRepository.save(loteOrigen);

        return pesajePolvoRepository.save(pesajePolvo);
    }
}
