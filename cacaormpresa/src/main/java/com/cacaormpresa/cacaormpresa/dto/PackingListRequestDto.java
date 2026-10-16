package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PackingListRequestDto {

    @NotBlank(message = "El código de Packing List es obligatorio")
    private String codigoPackingList;

    @NotNull(message = "El ID del pedido de venta es obligatorio")
    private Long pedidoId;

    @NotNull(message = "La fecha de despacho es obligatoria")
    private LocalDate fechaDespacho;

    @NotBlank(message = "El puerto de origen es obligatorio")
    private String puertoOrigen; // Ej: Puerto del Callao, Perú

    @NotBlank(message = "El puerto de destino es obligatorio")
    private String puertoDestino;

    private String navieraBuque;
    private String numeroContenedor;
    private String precintoAduanero;

    @NotNull(message = "El total de sacos de yute es obligatorio")
    @Positive(message = "Debe haber al menos un saco")
    private Integer totalSacosYute;

    @NotNull(message = "El peso neto es obligatorio")
    @Positive(message = "El peso neto debe ser positivo")
    private Double pesoNetoKg;

    @NotNull(message = "El peso bruto es obligatorio")
    @Positive(message = "El peso bruto debe ser positivo")
    private Double pesoBrutoKg;

    private String observaciones;

    public PackingListRequestDto() {}

    public String getCodigoPackingList() {
        return codigoPackingList;
    }

    public void setCodigoPackingList(String codigoPackingList) {
        this.codigoPackingList = codigoPackingList;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
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
}
