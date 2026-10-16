package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PesajePolvoRequestDto {

    @NotNull(message = "El ID del lote de origen es obligatorio")
    private Long loteOrigenId;

    @NotNull(message = "La fecha de procesamiento es obligatoria")
    private LocalDate fechaProcesamiento;

    @NotNull(message = "El peso de materia prima ingresada es obligatorio")
    @Positive(message = "El peso debe ser positivo")
    private Double pesoMateriaPrimaKg;

    @NotNull(message = "El peso de polvo de cacao obtenido es obligatorio")
    @Positive(message = "El peso debe ser positivo")
    private Double pesoPolvoCacaoKg;

    @NotNull(message = "El peso de manteca de cacao es obligatorio")
    private Double pesoMantecaCacaoKg;

    @NotNull(message = "El peso de cascarilla (merma) es obligatorio")
    private Double pesoCascarillaMermaKg;

    private String observaciones;

    public PesajePolvoRequestDto() {}

    public Long getLoteOrigenId() {
        return loteOrigenId;
    }

    public void setLoteOrigenId(Long loteOrigenId) {
        this.loteOrigenId = loteOrigenId;
    }

    public LocalDate getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDate fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public Double getPesoMateriaPrimaKg() {
        return pesoMateriaPrimaKg;
    }

    public void setPesoMateriaPrimaKg(Double pesoMateriaPrimaKg) {
        this.pesoMateriaPrimaKg = pesoMateriaPrimaKg;
    }

    public Double getPesoPolvoCacaoKg() {
        return pesoPolvoCacaoKg;
    }

    public void setPesoPolvoCacaoKg(Double pesoPolvoCacaoKg) {
        this.pesoPolvoCacaoKg = pesoPolvoCacaoKg;
    }

    public Double getPesoMantecaCacaoKg() {
        return pesoMantecaCacaoKg;
    }

    public void setPesoMantecaCacaoKg(Double pesoMantecaCacaoKg) {
        this.pesoMantecaCacaoKg = pesoMantecaCacaoKg;
    }

    public Double getPesoCascarillaMermaKg() {
        return pesoCascarillaMermaKg;
    }

    public void setPesoCascarillaMermaKg(Double pesoCascarillaMermaKg) {
        this.pesoCascarillaMermaKg = pesoCascarillaMermaKg;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
