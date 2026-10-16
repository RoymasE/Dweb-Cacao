package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.ControlSecado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControlSecadoRepository extends JpaRepository<ControlSecado, Long> {
    Optional<ControlSecado> findByLoteId(Long loteId);

    @Query("SELECT COALESCE(SUM(c.pesoSecoKg), 0.0) FROM ControlSecado c")
    Double sumTotalPesoSecoKg();
}
