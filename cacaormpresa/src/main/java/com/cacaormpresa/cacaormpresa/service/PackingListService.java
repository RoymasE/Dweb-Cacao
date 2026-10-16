package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.dto.PackingListRequestDto;
import com.cacaormpresa.cacaormpresa.entity.PackingList;
import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import com.cacaormpresa.cacaormpresa.exception.BusinessException;
import com.cacaormpresa.cacaormpresa.exception.ResourceNotFoundException;
import com.cacaormpresa.cacaormpresa.repository.PackingListRepository;
import com.cacaormpresa.cacaormpresa.repository.PedidoVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PackingListService {

    private final PackingListRepository packingListRepository;
    private final PedidoVentaRepository pedidoRepository;

    public PackingListService(PackingListRepository packingListRepository,
                              PedidoVentaRepository pedidoRepository) {
        this.packingListRepository = packingListRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<PackingList> listarTodos() {
        return packingListRepository.findAll();
    }

    public PackingList obtenerPorId(Long id) {
        return packingListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Packing List no encontrado con ID: " + id));
    }

    public PackingList obtenerPorPedido(Long pedidoId) {
        return packingListRepository.findByPedidoId(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Packing List no encontrado para pedido ID: " + pedidoId));
    }

    @Transactional
    public PackingList generarPackingList(PackingListRequestDto dto) {
        if (packingListRepository.findByCodigoPackingList(dto.getCodigoPackingList()).isPresent()) {
            throw new BusinessException("Ya existe un Packing List con código: " + dto.getCodigoPackingList());
        }

        PedidoVenta pedido = pedidoRepository.findById(dto.getPedidoId())
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + dto.getPedidoId()));

        if (pedido.getEstadoPedido() == PedidoVenta.EstadoPedido.CANCELADO) {
            throw new BusinessException("No se puede generar un Packing List para un pedido cancelado");
        }

        PackingList packing = new PackingList(
                dto.getCodigoPackingList(),
                pedido,
                dto.getFechaDespacho(),
                dto.getPuertoOrigen(),
                dto.getPuertoDestino(),
                dto.getNavieraBuque(),
                dto.getNumeroContenedor(),
                dto.getPrecintoAduanero(),
                dto.getTotalSacosYute(),
                dto.getPesoNetoKg(),
                dto.getPesoBrutoKg(),
                dto.getObservaciones()
        );

        pedido.setEstadoPedido(PedidoVenta.EstadoPedido.DESPACHADO);
        pedidoRepository.save(pedido);

        return packingListRepository.save(packing);
    }
}
