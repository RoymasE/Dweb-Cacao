package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.CajonFermentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CajonRepository extends JpaRepository<CajonFermentacion, Long> {
    Optional<CajonFermentacion> findByCodigoCajon(String codigoCajon);
    List<CajonFermentacion> findByEstado(CajonFermentacion.EstadoCajon estado);
}
