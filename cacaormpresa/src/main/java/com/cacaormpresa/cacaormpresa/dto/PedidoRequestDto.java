package com.cacaormpresa.cacaormpresa.dto;

import com.cacaormpresa.cacaormpresa.entity.PedidoVenta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PedidoRequestDto {

    @NotBlank(message = "El número de pedido es obligatorio")
    private String numeroPedido;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "La fecha del pedido es obligatoria")
    private LocalDate fechaPedido;

    @NotNull(message = "La sección de producto es obligatoria (SECCION_1_GRANOS o SECCION_2_POLVO)")
    private PedidoVenta.SeccionProducto seccionProducto;

    @NotNull(message = "La cantidad en kg es obligatoria")
    @Positive(message = "La cantidad debe ser mayor a cero")
    private Double cantidadKg;

    @NotNull(message = "El precio unitario en USD es obligatorio")
    @Positive(message = "El precio unitario debe ser mayor a cero")
    private Double precioUnitarioUsd;

    private String destinoFinal;
    private String notas;

    public PedidoRequestDto() {}

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public PedidoVenta.SeccionProducto getSeccionProducto() {
        return seccionProducto;
    }

    public void setSeccionProducto(PedidoVenta.SeccionProducto seccionProducto) {
        this.seccionProducto = seccionProducto;
    }

    public Double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(Double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public Double getPrecioUnitarioUsd() {
        return precioUnitarioUsd;
    }

    public void setPrecioUnitarioUsd(Double precioUnitarioUsd) {
        this.precioUnitarioUsd = precioUnitarioUsd;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
