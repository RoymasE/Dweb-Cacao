package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Optional<Proveedor> findByDniRuc(String dniRuc);
    List<Proveedor> findByActivoTrue();
    List<Proveedor> findByComunidadSectorContainingIgnoreCase(String comunidad);
}
