package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.AreaPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaPlantaRepository extends JpaRepository<AreaPlanta, Long> {
    Optional<AreaPlanta> findByNombre(String nombre);
}
