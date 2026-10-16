package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "control_secado")
public class ControlSecado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "lote_id", unique = true)
    private LoteCacao lote;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Column(nullable = false)
    private Double humedadPorcentaje; // Medición de humedad solar (meta técnica: ~7%)

    @Column(nullable = false)
    private Double pesoSecoKg; // Peso obtenido tras secado

    private Integer diasSecado;

    @Column(nullable = false)
    private Boolean humedadOptimaAlcanzada = false; // true si humedad <= 7.5%

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaRegistro;

    public ControlSecado() {
    }

    public ControlSecado(LoteCacao lote, LocalDate fechaInicio, LocalDate fechaFin,
                         Double humedadPorcentaje, Double pesoSecoKg, Integer diasSecado, String observaciones) {
        this.lote = lote;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.humedadPorcentaje = humedadPorcentaje;
        this.pesoSecoKg = pesoSecoKg;
        this.diasSecado = diasSecado;
        this.observaciones = observaciones;
        this.humedadOptimaAlcanzada = (humedadPorcentaje != null && humedadPorcentaje <= 7.5);
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
        if (this.humedadPorcentaje != null) {
            this.humedadOptimaAlcanzada = (this.humedadPorcentaje <= 7.5);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoteCacao getLote() {
        return lote;
    }

    public void setLote(LoteCacao lote) {
        this.lote = lote;
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
        this.humedadOptimaAlcanzada = (humedadPorcentaje != null && humedadPorcentaje <= 7.5);
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

    public Boolean getHumedadOptimaAlcanzada() {
        return humedadOptimaAlcanzada;
    }

    public void setHumedadOptimaAlcanzada(Boolean humedadOptimaAlcanzada) {
        this.humedadOptimaAlcanzada = humedadOptimaAlcanzada;
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
