package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoreo_fermentacion")
public class MonitoreoFermentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lote_id")
    private LoteCacao lote;

    @Column(nullable = false)
    private Integer diaNumero; // Día 1 al 6

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(nullable = false)
    private Double temperaturaCelsius; // Temperatura en °C (rango normado 45°C - 50°C)

    @Column(nullable = false)
    private Boolean volteoRealizado = false; // Control de volteo periódico

    @Column(nullable = false)
    private Boolean alertaTemperatura = false; // Alerta si está fuera de 45°C - 50°C

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaHoraCreacion;

    public MonitoreoFermentacion() {
    }

    public MonitoreoFermentacion(LoteCacao lote, Integer diaNumero, LocalDate fechaRegistro,
                                 Double temperaturaCelsius, Boolean volteoRealizado, String observaciones) {
        this.lote = lote;
        this.diaNumero = diaNumero;
        this.fechaRegistro = fechaRegistro;
        this.temperaturaCelsius = temperaturaCelsius;
        this.volteoRealizado = volteoRealizado;
        this.observaciones = observaciones;
        // Alerta semafórica de temperatura (norma técnica 45 - 50 °C)
        this.alertaTemperatura = (temperaturaCelsius < 45.0 || temperaturaCelsius > 50.0);
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaHoraCreacion == null) {
            this.fechaHoraCreacion = LocalDateTime.now();
        }
        if (this.temperaturaCelsius != null) {
            this.alertaTemperatura = (this.temperaturaCelsius < 45.0 || this.temperaturaCelsius > 50.0);
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
        this.alertaTemperatura = (temperaturaCelsius != null && (temperaturaCelsius < 45.0 || temperaturaCelsius > 50.0));
    }

    public Boolean getVolteoRealizado() {
        return volteoRealizado;
    }

    public void setVolteoRealizado(Boolean volteoRealizado) {
        this.volteoRealizado = volteoRealizado;
    }

    public Boolean getAlertaTemperatura() {
        return alertaTemperatura;
    }

    public void setAlertaTemperatura(Boolean alertaTemperatura) {
        this.alertaTemperatura = alertaTemperatura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }
}
