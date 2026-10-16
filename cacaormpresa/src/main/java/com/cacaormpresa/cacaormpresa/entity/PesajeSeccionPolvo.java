package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pesajes_seccion_polvo")
public class PesajeSeccionPolvo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lote_origen_id")
    private LoteCacao loteOrigen;

    @Column(nullable = false)
    private LocalDate fechaProcesamiento;

    @Column(nullable = false)
    private Double pesoMateriaPrimaKg; // Granos ingresados a tostado y molienda

    @Column(nullable = false)
    private Double pesoPolvoCacaoKg; // Polvo de cacao obtenido (derivado principal)

    @Column(nullable = false)
    private Double pesoMantecaCacaoKg; // Manteca separada en prensado

    @Column(nullable = false)
    private Double pesoCascarillaMermaKg; // Cascarilla descartada (merma de procesamiento)

    @Column(nullable = false)
    private Double stockDisponiblePolvoKg; // Para control de ventas y pedidos

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaRegistro;

    public PesajeSeccionPolvo() {
    }

    public PesajeSeccionPolvo(LoteCacao loteOrigen, LocalDate fechaProcesamiento, Double pesoMateriaPrimaKg,
                              Double pesoPolvoCacaoKg, Double pesoMantecaCacaoKg, Double pesoCascarillaMermaKg, String observaciones) {
        this.loteOrigen = loteOrigen;
        this.fechaProcesamiento = fechaProcesamiento;
        this.pesoMateriaPrimaKg = pesoMateriaPrimaKg;
        this.pesoPolvoCacaoKg = pesoPolvoCacaoKg;
        this.pesoMantecaCacaoKg = pesoMantecaCacaoKg;
        this.pesoCascarillaMermaKg = pesoCascarillaMermaKg;
        this.stockDisponiblePolvoKg = pesoPolvoCacaoKg;
        this.observaciones = observaciones;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
        if (this.stockDisponiblePolvoKg == null && this.pesoPolvoCacaoKg != null) {
            this.stockDisponiblePolvoKg = this.pesoPolvoCacaoKg;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoteCacao getLoteOrigen() {
        return loteOrigen;
    }

    public void setLoteOrigen(LoteCacao loteOrigen) {
        this.loteOrigen = loteOrigen;
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

    public Double getStockDisponiblePolvoKg() {
        return stockDisponiblePolvoKg;
    }

    public void setStockDisponiblePolvoKg(Double stockDisponiblePolvoKg) {
        this.stockDisponiblePolvoKg = stockDisponiblePolvoKg;
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
