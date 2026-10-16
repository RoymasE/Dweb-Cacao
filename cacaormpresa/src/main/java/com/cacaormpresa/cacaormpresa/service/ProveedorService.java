package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.entity.Proveedor;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public List<Proveedor> listarActivos() {
        return proveedorRepository.findByActivoTrue();
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    @Transactional
    public Proveedor crear(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Transactional
    public Proveedor actualizar(Long id, Proveedor data) {
        Proveedor prov = obtenerPorId(id);
        prov.setNombreCompleto(data.getNombreCompleto());
        prov.setDniRuc(data.getDniRuc());
        prov.setComunidadSector(data.getComunidadSector());
        prov.setParcelaOrigen(data.getParcelaOrigen());
        prov.setCodigoContratoComunal(data.getCodigoContratoComunal());
        prov.setTelefono(data.getTelefono());
        prov.setHectareas(data.getHectareas());
        if (data.getActivo() != null) {
            prov.setActivo(data.getActivo());
        }
        return proveedorRepository.save(prov);
    }

    @Transactional
    public void cambiarEstado(Long id, boolean activo) {
        Proveedor prov = obtenerPorId(id);
        prov.setActivo(activo);
        proveedorRepository.save(prov);
    }
}
