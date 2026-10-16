package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.PedidoRequestDto;
import com.cacaormpresa.cacaormpresa.entity.Cliente;
import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionGranos;
import com.cacaormpresa.cacaormpresa.entity.PesajeSeccionPolvo;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.ClienteRepository;
import com.cacaormpresa.cacaormpresa.repository.PedidoVentaRepository;
import com.cacaormpresa.cacaormpresa.repository.PesajeGranosRepository;
import com.cacaormpresa.cacaormpresa.repository.PesajePolvoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoVentaService {

    private final PedidoVentaRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PesajeGranosRepository pesajeGranosRepository;
    private final PesajePolvoRepository pesajePolvoRepository;

    public PedidoVentaService(PedidoVentaRepository pedidoRepository,
                              ClienteRepository clienteRepository,
                              PesajeGranosRepository pesajeGranosRepository,
                              PesajePolvoRepository pesajePolvoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pesajeGranosRepository = pesajeGranosRepository;
        this.pesajePolvoRepository = pesajePolvoRepository;
    }

    public List<PedidoVenta> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<PedidoVenta> listarPorEstado(PedidoVenta.EstadoPedido estado) {
        return pedidoRepository.findByEstadoPedido(estado);
    }

    public PedidoVenta obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
    }

    @Transactional
    public PedidoVenta crearPedido(PedidoRequestDto dto) {
        if (pedidoRepository.findByNumeroPedido(dto.getNumeroPedido()).isPresent()) {
            throw new BusinessException("Ya existe un pedido registrado con el número: " + dto.getNumeroPedido());
        }

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + dto.getClienteId()));

        // Validar disponibilidad de stock en la sección elegida
        if (dto.getSeccionProducto() == PedidoVenta.SeccionProducto.SECCION_1_GRANOS) {
            Double stockDisponible = pesajeGranosRepository.sumStockDisponibleGranosKg();
            if (stockDisponible < dto.getCantidadKg()) {
                throw new BusinessException("Restricción (HU-10): Stock insuficiente en Sección 1 (Granos). " +
                        "Stock disponible: " + stockDisponible + " kg, solicitado: " + dto.getCantidadKg() + " kg");
            }
        } else if (dto.getSeccionProducto() == PedidoVenta.SeccionProducto.SECCION_2_POLVO) {
            Double stockDisponible = pesajePolvoRepository.sumStockDisponiblePolvoKg();
            if (stockDisponible < dto.getCantidadKg()) {
                throw new BusinessException("Restricción (HU-10): Stock insuficiente en Sección 2 (Polvo). " +
                        "Stock disponible: " + stockDisponible + " kg, solicitado: " + dto.getCantidadKg() + " kg");
            }
        }

        PedidoVenta pedido = new PedidoVenta(
                dto.getNumeroPedido(),
                cliente,
                dto.getFechaPedido(),
                dto.getSeccionProducto(),
                dto.getCantidadKg(),
                dto.getPrecioUnitarioUsd(),
                dto.getDestinoFinal(),
                dto.getNotas()
        );

        return pedidoRepository.save(pedido);
    }

    @Transactional
    public PedidoVenta confirmarPedido(Long pedidoId) {
        PedidoVenta pedido = obtenerPorId(pedidoId);

        if (pedido.getEstadoPedido() != PedidoVenta.EstadoPedido.PENDIENTE) {
            throw new BusinessException("Solo se pueden confirmar pedidos en estado PENDIENTE");
        }

        // Descontar stock real con transacción ACID
        if (pedido.getSeccionProducto() == PedidoVenta.SeccionProducto.SECCION_1_GRANOS) {
            double porDescontar = pedido.getCantidadKg();
            List<PesajeSeccionGranos> granos = pesajeGranosRepository.findAll();
            for (PesajeSeccionGranos g : granos) {
                if (g.getStockDisponibleKg() > 0) {
                    double disponible = g.getStockDisponibleKg();
                    if (disponible >= porDescontar) {
                        g.setStockDisponibleKg(disponible - porDescontar);
                        pesajeGranosRepository.save(g);
                        porDescontar = 0;
                        break;
                    } else {
                        porDescontar -= disponible;
                        g.setStockDisponibleKg(0.0);
                        pesajeGranosRepository.save(g);
                    }
                }
            }
            if (porDescontar > 0) {
                throw new BusinessException("Stock insuficiente en Sección 1 para confirmar venta");
            }
        } else {
            double porDescontar = pedido.getCantidadKg();
            List<PesajeSeccionPolvo> polvos = pesajePolvoRepository.findAll();
            for (PesajeSeccionPolvo p : polvos) {
                if (p.getStockDisponiblePolvoKg() > 0) {
                    double disponible = p.getStockDisponiblePolvoKg();
                    if (disponible >= porDescontar) {
                        p.setStockDisponiblePolvoKg(disponible - porDescontar);
                        pesajePolvoRepository.save(p);
                        porDescontar = 0;
                        break;
                    } else {
                        porDescontar -= disponible;
                        p.setStockDisponiblePolvoKg(0.0);
                        pesajePolvoRepository.save(p);
                    }
                }
            }
            if (porDescontar > 0) {
                throw new BusinessException("Stock insuficiente en Sección 2 para confirmar venta");
            }
        }

        pedido.setEstadoPedido(PedidoVenta.EstadoPedido.CONFIRMADO);
        return pedidoRepository.save(pedido);
    }
}
