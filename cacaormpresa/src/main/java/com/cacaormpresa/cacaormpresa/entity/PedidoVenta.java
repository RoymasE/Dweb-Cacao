package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos_ventas")
public class PedidoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroPedido; // Ej: PED-2026-001

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private SeccionProducto seccionProducto; // SECCION_1_GRANOS o SECCION_2_POLVO

    @Column(nullable = false)
    private Double cantidadKg;

    @Column(nullable = false)
    private Double precioUnitarioUsd;

    @Column(nullable = false)
    private Double totalUsd;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoPedido estadoPedido = EstadoPedido.PENDIENTE;

    @Column(length = 255)
    private String destinoFinal;

    @Column(length = 255)
    private String notas;

    private LocalDateTime fechaCreacion;

    public enum SeccionProducto {
        SECCION_1_GRANOS,
        SECCION_2_POLVO
    }

    public enum EstadoPedido {
        PENDIENTE,
        CONFIRMADO,
        EN_PREPARACION,
        DESPACHADO,
        CANCELADO
    }

    public PedidoVenta() {
    }

    public PedidoVenta(String numeroPedido, Cliente cliente, LocalDate fechaPedido,
                       SeccionProducto seccionProducto, Double cantidadKg, Double precioUnitarioUsd,
                       String destinoFinal, String notas) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.seccionProducto = seccionProducto;
        this.cantidadKg = cantidadKg;
        this.precioUnitarioUsd = precioUnitarioUsd;
        this.totalUsd = cantidadKg * precioUnitarioUsd;
        this.destinoFinal = destinoFinal;
        this.notas = notas;
        this.estadoPedido = EstadoPedido.PENDIENTE;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
        if (this.estadoPedido == null) {
            this.estadoPedido = EstadoPedido.PENDIENTE;
        }
        if (this.cantidadKg != null && this.precioUnitarioUsd != null) {
            this.totalUsd = this.cantidadKg * this.precioUnitarioUsd;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public SeccionProducto getSeccionProducto() {
        return seccionProducto;
    }

    public void setSeccionProducto(SeccionProducto seccionProducto) {
        this.seccionProducto = seccionProducto;
    }

    public Double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(Double cantidadKg) {
        this.cantidadKg = cantidadKg;
        if (cantidadKg != null && this.precioUnitarioUsd != null) {
            this.totalUsd = cantidadKg * this.precioUnitarioUsd;
        }
    }

    public Double getPrecioUnitarioUsd() {
        return precioUnitarioUsd;
    }

    public void setPrecioUnitarioUsd(Double precioUnitarioUsd) {
        this.precioUnitarioUsd = precioUnitarioUsd;
        if (this.cantidadKg != null && precioUnitarioUsd != null) {
            this.totalUsd = this.cantidadKg * precioUnitarioUsd;
        }
    }

    public Double getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(Double totalUsd) {
        this.totalUsd = totalUsd;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
