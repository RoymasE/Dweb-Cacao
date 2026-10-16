package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.LoteRequestDto;
import com.cacaormpresa.cacaormpresa.entity.CajonFermentacion;
import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import com.cacaormpresa.cacaormpresa.entity.Proveedor;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.CajonRepository;
import com.cacaormpresa.cacaormpresa.repository.LoteCacaoRepository;
import com.cacaormpresa.cacaormpresa.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CosechaService {

    private final LoteCacaoRepository loteRepository;
    private final ProveedorRepository proveedorRepository;
    private final CajonRepository cajonRepository;

    public CosechaService(LoteCacaoRepository loteRepository,
                          ProveedorRepository proveedorRepository,
                          CajonRepository cajonRepository) {
        this.loteRepository = loteRepository;
        this.proveedorRepository = proveedorRepository;
        this.cajonRepository = cajonRepository;
    }

    public List<LoteCacao> listarTodos() {
        return loteRepository.findAll();
    }

    public List<LoteCacao> listarPorEstado(LoteCacao.EstadoLote estado) {
        return loteRepository.findByEstado(estado);
    }

    public LoteCacao obtenerPorId(Long id) {
        return loteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lote de cacao no encontrado con ID: " + id));
    }

    public LoteCacao obtenerPorCodigo(String codigoLote) {
        return loteRepository.findByCodigoLote(codigoLote)
                .orElseThrow(() -> new ResourceNotFoundException("Lote con código " + codigoLote + " no encontrado"));
    }

    @Transactional
    public LoteCacao registrarCosechaBaba(LoteRequestDto dto) {
        if (loteRepository.findByCodigoLote(dto.getCodigoLote()).isPresent()) {
            throw new BusinessException("Ya existe un lote registrado con el código: " + dto.getCodigoLote());
        }

        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + dto.getProveedorId()));

        CajonFermentacion cajon = null;
        if (dto.getCajonId() != null) {
            cajon = cajonRepository.findById(dto.getCajonId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cajón no encontrado con ID: " + dto.getCajonId()));
            cajon.setEstado(CajonFermentacion.EstadoCajon.EN_FERMENTACION);
            cajonRepository.save(cajon);
        }

        LoteCacao lote = new LoteCacao(
                dto.getCodigoLote(),
                dto.getFechaCosecha(),
                dto.getFechaRecepcion(),
                proveedor,
                cajon,
                dto.getVariedad(),
                dto.getPesoBabaKg()
        );
        lote.setObservaciones(dto.getObservaciones());
        if (cajon != null) {
            lote.setEstado(LoteCacao.EstadoLote.EN_FERMENTACION);
        }

        return loteRepository.save(lote);
    }
}
