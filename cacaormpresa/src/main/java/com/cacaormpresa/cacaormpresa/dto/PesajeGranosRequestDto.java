package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PesajeGranosRequestDto {

    @NotNull(message = "El ID del lote es obligatorio")
    private Long loteId;

    @NotNull(message = "La fecha de pesaje es obligatoria")
    private LocalDate fechaPesaje;

    @NotNull(message = "El peso de granos secos es obligatorio")
    @Positive(message = "El peso en kilogramos debe ser positivo")
    private Double pesoGranosKg;

    @NotBlank(message = "El grado de calidad es obligatorio")
    private String calidadGrado; // Grado 1 (Exportación), Grado 2

    private String observaciones;

    public PesajeGranosRequestDto() {}

    public Long getLoteId() {
        return loteId;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public LocalDate getFechaPesaje() {
        return fechaPesaje;
    }

    public void setFechaPesaje(LocalDate fechaPesaje) {
        this.fechaPesaje = fechaPesaje;
    }

    public Double getPesoGranosKg() {
        return pesoGranosKg;
    }

    public void setPesoGranosKg(Double pesoGranosKg) {
        this.pesoGranosKg = pesoGranosKg;
    }

    public String getCalidadGrado() {
        return calidadGrado;
    }

    public void setCalidadGrado(String calidadGrado) {
        this.calidadGrado = calidadGrado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
