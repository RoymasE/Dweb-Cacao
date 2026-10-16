package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.entity.CajonFermentacion;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.CajonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CajonService {

    private final CajonRepository cajonRepository;

    public CajonService(CajonRepository cajonRepository) {
        this.cajonRepository = cajonRepository;
    }

    public List<CajonFermentacion> listarTodos() {
        return cajonRepository.findAll();
    }

    public List<CajonFermentacion> listarDisponibles() {
        return cajonRepository.findByEstado(CajonFermentacion.EstadoCajon.DISPONIBLE);
    }

    public CajonFermentacion obtenerPorId(Long id) {
        return cajonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cajón de fermentación no encontrado con ID: " + id));
    }

    @Transactional
    public CajonFermentacion crear(CajonFermentacion cajon) {
        if (cajonRepository.findByCodigoCajon(cajon.getCodigoCajon()).isPresent()) {
            throw new BusinessException("Ya existe un cajón con el código: " + cajon.getCodigoCajon());
        }
        return cajonRepository.save(cajon);
    }

    @Transactional
    public CajonFermentacion actualizarEstado(Long id, CajonFermentacion.EstadoCajon nuevoEstado) {
        CajonFermentacion cajon = obtenerPorId(id);
        cajon.setEstado(nuevoEstado);
        return cajonRepository.save(cajon);
    }
}
