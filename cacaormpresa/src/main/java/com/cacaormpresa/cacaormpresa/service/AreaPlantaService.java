package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.entity.AreaPlanta;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.AreaPlantaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaPlantaService {

    private final AreaPlantaRepository areaPlantaRepository;

    public AreaPlantaService(AreaPlantaRepository areaPlantaRepository) {
        this.areaPlantaRepository = areaPlantaRepository;
    }

    public List<AreaPlanta> listarTodas() {
        return areaPlantaRepository.findAll();
    }

    public AreaPlanta obtenerPorId(Long id) {
        return areaPlantaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Área de planta no encontrada con ID: " + id));
    }

    public AreaPlanta guardar(AreaPlanta areaPlanta) {
        return areaPlantaRepository.save(areaPlanta);
    }
}
