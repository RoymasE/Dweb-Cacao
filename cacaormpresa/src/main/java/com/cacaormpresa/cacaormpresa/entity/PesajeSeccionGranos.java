package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pesajes_seccion_granos")
public class PesajeSeccionGranos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "lote_id", unique = true)
    private LoteCacao lote;

    @Column(nullable = false)
    private LocalDate fechaPesaje;

    @Column(nullable = false)
    private Double pesoGranosKg; // Peso en kilogramos

    @Column(nullable = false)
    private Double pesoToneladas; // Calculado pesoGranosKg / 1000

    @Column(nullable = false)
    private Integer sacos60kg; // Sacos de 60 kg estándar de exportación

    @Column(length = 50)
    private String calidadGrado; // Grado 1 (Exportación), Grado 2

    @Column(nullable = false)
    private Double stockDisponibleKg; // Para control de ventas y reservas

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaRegistro;

    public PesajeSeccionGranos() {
    }

    public PesajeSeccionGranos(LoteCacao lote, LocalDate fechaPesaje, Double pesoGranosKg, String calidadGrado, String observaciones) {
        this.lote = lote;
        this.fechaPesaje = fechaPesaje;
        this.pesoGranosKg = pesoGranosKg;
        this.pesoToneladas = pesoGranosKg / 1000.0;
        this.sacos60kg = (int) Math.floor(pesoGranosKg / 60.0);
        this.calidadGrado = calidadGrado;
        this.stockDisponibleKg = pesoGranosKg;
        this.observaciones = observaciones;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
        if (this.pesoGranosKg != null) {
            this.pesoToneladas = this.pesoGranosKg / 1000.0;
            this.sacos60kg = (int) Math.floor(this.pesoGranosKg / 60.0);
            if (this.stockDisponibleKg == null) {
                this.stockDisponibleKg = this.pesoGranosKg;
            }
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
        if (pesoGranosKg != null) {
            this.pesoToneladas = pesoGranosKg / 1000.0;
            this.sacos60kg = (int) Math.floor(pesoGranosKg / 60.0);
        }
    }

    public Double getPesoToneladas() {
        return pesoToneladas;
    }

    public void setPesoToneladas(Double pesoToneladas) {
        this.pesoToneladas = pesoToneladas;
    }

    public Integer getSacos60kg() {
        return sacos60kg;
    }

    public void setSacos60kg(Integer sacos60kg) {
        this.sacos60kg = sacos60kg;
    }

    public String getCalidadGrado() {
        return calidadGrado;
    }

    public void setCalidadGrado(String calidadGrado) {
        this.calidadGrado = calidadGrado;
    }

    public Double getStockDisponibleKg() {
        return stockDisponibleKg;
    }

    public void setStockDisponibleKg(Double stockDisponibleKg) {
        this.stockDisponibleKg = stockDisponibleKg;
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
