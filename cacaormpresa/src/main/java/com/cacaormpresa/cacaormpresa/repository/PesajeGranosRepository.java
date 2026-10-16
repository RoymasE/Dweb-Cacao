package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionGranos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PesajeGranosRepository extends JpaRepository<PesajeSeccionGranos, Long> {
    Optional<PesajeSeccionGranos> findByLoteId(Long loteId);

    @Query("SELECT COALESCE(SUM(p.pesoGranosKg), 0.0) FROM PesajeSeccionGranos p")
    Double sumTotalGranosKg();

    @Query("SELECT COALESCE(SUM(p.stockDisponibleKg), 0.0) FROM PesajeSeccionGranos p")
    Double sumStockDisponibleGranosKg();
}
