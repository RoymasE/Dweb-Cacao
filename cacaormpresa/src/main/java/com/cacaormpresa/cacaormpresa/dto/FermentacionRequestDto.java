package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class FermentacionRequestDto {

    @NotNull(message = "El ID del lote es obligatorio")
    private Long loteId;

    @NotNull(message = "El número de día es obligatorio")
    @Min(value = 1, message = "El día debe ser entre 1 y 6")
    @Max(value = 6, message = "El día debe ser entre 1 y 6")
    private Integer diaNumero;

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;

    @NotNull(message = "La temperatura es obligatoria")
    private Double temperaturaCelsius;

    @NotNull(message = "Debe indicar si se realizó el volteo")
    private Boolean volteoRealizado;

    private String observaciones;

    public FermentacionRequestDto() {}

    public Long getLoteId() {
        return loteId;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public Integer getDiaNumero() {
        return diaNumero;
    }

    public void setDiaNumero(Integer diaNumero) {
        this.diaNumero = diaNumero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }

    public void setTemperaturaCelsius(Double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }

    public Boolean getVolteoRealizado() {
        return volteoRealizado;
    }

    public void setVolteoRealizado(Boolean volteoRealizado) {
        this.volteoRealizado = volteoRealizado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
