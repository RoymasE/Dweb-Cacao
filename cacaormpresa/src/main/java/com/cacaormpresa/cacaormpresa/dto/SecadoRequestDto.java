package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class SecadoRequestDto {

    @NotNull(message = "El ID del lote es obligatorio")
    private Long loteId;

    @NotNull(message = "La fecha de inicio de secado es obligatoria")
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @NotNull(message = "El porcentaje de humedad es obligatorio")
    private Double humedadPorcentaje;

    @NotNull(message = "El peso seco es obligatorio")
    @Positive(message = "El peso seco debe ser mayor a cero")
    private Double pesoSecoKg;

    private Integer diasSecado;

    private String observaciones;

    public SecadoRequestDto() {}

    public Long getLoteId() {
        return loteId;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getHumedadPorcentaje() {
        return humedadPorcentaje;
    }

    public void setHumedadPorcentaje(Double humedadPorcentaje) {
        this.humedadPorcentaje = humedadPorcentaje;
    }

    public Double getPesoSecoKg() {
        return pesoSecoKg;
    }

    public void setPesoSecoKg(Double pesoSecoKg) {
        this.pesoSecoKg = pesoSecoKg;
    }

    public Integer getDiasSecado() {
        return diasSecado;
    }

    public void setDiasSecado(Integer diasSecado) {
        this.diasSecado = diasSecado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
