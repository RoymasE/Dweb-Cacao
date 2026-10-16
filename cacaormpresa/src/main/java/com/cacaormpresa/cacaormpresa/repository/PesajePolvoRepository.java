package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionPolvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesajePolvoRepository extends JpaRepository<PesajeSeccionPolvo, Long> {
    List<PesajeSeccionPolvo> findByLoteOrigenId(Long loteId);

    @Query("SELECT COALESCE(SUM(p.pesoPolvoCacaoKg), 0.0) FROM PesajeSeccionPolvo p")
    Double sumTotalPolvoCacaoKg();

    @Query("SELECT COALESCE(SUM(p.pesoMateriaPrimaKg), 0.0) FROM PesajeSeccionPolvo p")
    Double sumTotalMateriaPrimaKg();

    @Query("SELECT COALESCE(SUM(p.pesoMantecaCacaoKg), 0.0) FROM PesajeSeccionPolvo p")
    Double sumTotalMantecaKg();

    @Query("SELECT COALESCE(SUM(p.pesoCascarillaMermaKg), 0.0) FROM PesajeSeccionPolvo p")
    Double sumTotalCascarillaMermaKg();

    @Query("SELECT COALESCE(SUM(p.stockDisponiblePolvoKg), 0.0) FROM PesajeSeccionPolvo p")
    Double sumStockDisponiblePolvoKg();
}
