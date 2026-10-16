package com.cacaormpresa.cacaormpresa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class LoteRequestDto {

    @NotBlank(message = "El código de lote es obligatorio")
    private String codigoLote;

    @NotNull(message = "La fecha de cosecha es obligatoria")
    private LocalDate fechaCosecha;

    @NotNull(message = "La fecha de recepción es obligatoria")
    private LocalDate fechaRecepcion;

    @NotNull(message = "El ID del proveedor es obligatorio")
    private Long proveedorId;

    private Long cajonId; // Puede ser asignado de inmediato o durante fermentación

    @NotBlank(message = "La variedad de cacao es obligatoria")
    private String variedad;

    @NotNull(message = "El peso del cacao en baba es obligatorio")
    @Positive(message = "El peso en baba debe ser un valor positivo")
    private Double pesoBabaKg;

    private String observaciones;

    public LoteRequestDto() {}

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public LocalDate getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(LocalDate fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getCajonId() {
        return cajonId;
    }

    public void setCajonId(Long cajonId) {
        this.cajonId = cajonId;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public Double getPesoBabaKg() {
        return pesoBabaKg;
    }

    public void setPesoBabaKg(Double pesoBabaKg) {
        this.pesoBabaKg = pesoBabaKg;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
