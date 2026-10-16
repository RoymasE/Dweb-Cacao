package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "packing_lists")
public class PackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String codigoPackingList; // Ej: PKL-2026-001

    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id", unique = true)
    private PedidoVenta pedido;

    @Column(nullable = false)
    private LocalDate fechaDespacho;

    @Column(nullable = false, length = 100)
    private String puertoOrigen; // Ej: Puerto del Callao, Perú

    @Column(nullable = false, length = 100)
    private String puertoDestino; // Ej: Hamburgo (Alemania), Róterdam (Países Bajos)

    @Column(length = 100)
    private String navieraBuque; // Ej: Maersk / MSC

    @Column(length = 50)
    private String numeroContenedor;

    @Column(length = 50)
    private String precintoAduanero;

    @Column(nullable = false)
    private Integer totalSacosYute; // Sacos de 60 kg

    @Column(nullable = false)
    private Double pesoNetoKg;

    @Column(nullable = false)
    private Double pesoBrutoKg;

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaRegistro;

    public PackingList() {
    }

    public PackingList(String codigoPackingList, PedidoVenta pedido, LocalDate fechaDespacho,
                       String puertoOrigen, String puertoDestino, String navieraBuque,
                       String numeroContenedor, String precintoAduanero, Integer totalSacosYute,
                       Double pesoNetoKg, Double pesoBrutoKg, String observaciones) {
        this.codigoPackingList = codigoPackingList;
        this.pedido = pedido;
        this.fechaDespacho = fechaDespacho;
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
        this.navieraBuque = navieraBuque;
        this.numeroContenedor = numeroContenedor;
        this.precintoAduanero = precintoAduanero;
        this.totalSacosYute = totalSacosYute;
        this.pesoNetoKg = pesoNetoKg;
        this.pesoBrutoKg = pesoBrutoKg;
        this.observaciones = observaciones;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPackingList() {
        return codigoPackingList;
    }

    public void setCodigoPackingList(String codigoPackingList) {
        this.codigoPackingList = codigoPackingList;
    }

    public PedidoVenta getPedido() {
        return pedido;
    }

    public void setPedido(PedidoVenta pedido) {
        this.pedido = pedido;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getPuertoOrigen() {
        return puertoOrigen;
    }

    public void setPuertoOrigen(String puertoOrigen) {
        this.puertoOrigen = puertoOrigen;
    }

    public String getPuertoDestino() {
        return puertoDestino;
    }

    public void setPuertoDestino(String puertoDestino) {
        this.puertoDestino = puertoDestino;
    }

    public String getNavieraBuque() {
        return navieraBuque;
    }

    public void setNavieraBuque(String navieraBuque) {
        this.navieraBuque = navieraBuque;
    }

    public String getNumeroContenedor() {
        return numeroContenedor;
    }

    public void setNumeroContenedor(String numeroContenedor) {
        this.numeroContenedor = numeroContenedor;
    }

    public String getPrecintoAduanero() {
        return precintoAduanero;
    }

    public void setPrecintoAduanero(String precintoAduanero) {
        this.precintoAduanero = precintoAduanero;
    }

    public Integer getTotalSacosYute() {
        return totalSacosYute;
    }

    public void setTotalSacosYute(Integer totalSacosYute) {
        this.totalSacosYute = totalSacosYute;
    }

    public Double getPesoNetoKg() {
        return pesoNetoKg;
    }

    public void setPesoNetoKg(Double pesoNetoKg) {
        this.pesoNetoKg = pesoNetoKg;
    }

    public Double getPesoBrutoKg() {
        return pesoBrutoKg;
    }

    public void setPesoBrutoKg(Double pesoBrutoKg) {
        this.pesoBrutoKg = pesoBrutoKg;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
