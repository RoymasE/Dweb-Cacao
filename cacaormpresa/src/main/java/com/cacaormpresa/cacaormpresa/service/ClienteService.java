package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.entity.Cliente;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> listarActivos() {
        return clienteRepository.findByActivoTrue();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
    }

    @Transactional
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente actualizar(Long id, Cliente data) {
        Cliente cl = obtenerPorId(id);
        cl.setNombreEmpresa(data.getNombreEmpresa());
        cl.setPaisDestino(data.getPaisDestino());
        cl.setPersonaContacto(data.getPersonaContacto());
        cl.setEmail(data.getEmail());
        cl.setTelefono(data.getTelefono());
        cl.setDireccionFiscal(data.getDireccionFiscal());
        if (data.getActivo() != null) {
            cl.setActivo(data.getActivo());
        }
        return clienteRepository.save(cl);
    }

    @Transactional
    public void cambiarEstado(Long id, boolean activo) {
        Cliente cl = obtenerPorId(id);
        cl.setActivo(activo);
        clienteRepository.save(cl);
    }
}
