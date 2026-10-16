package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.MonitoreoFermentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitoreoFermentacionRepository extends JpaRepository<MonitoreoFermentacion, Long> {
    List<MonitoreoFermentacion> findByLoteIdOrderByDiaNumeroAsc(Long loteId);
    List<MonitoreoFermentacion> findByAlertaTemperaturaTrue();
    Long countByLoteId(Long loteId);
}
