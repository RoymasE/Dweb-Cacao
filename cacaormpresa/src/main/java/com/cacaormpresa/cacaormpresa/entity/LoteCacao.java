package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lotes_cacao")
public class LoteCacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String codigoLote; // Ej: LOTE-2026-001

    @Column(nullable = false)
    private LocalDate fechaCosecha;

    @Column(nullable = false)
    private LocalDate fechaRecepcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "cajon_id")
    private CajonFermentacion cajon;

    @Column(nullable = false, length = 50)
    private String variedad; // Ej: Cacao Criollo Fino de Aroma, Trinitario, CCN-51

    @Column(nullable = false)
    private Double pesoBabaKg; // Peso cosechado ingresado en baba (RF-06)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private EstadoLote estado = EstadoLote.RECEPCIONADO;

    @Column(length = 255)
    private String observaciones;

    private LocalDateTime fechaCreacion;

    public enum EstadoLote {
        RECEPCIONADO,
        EN_FERMENTACION,
        FERMENTADO,
        EN_SECADO,
        SECADO_COMPLETO,
        EN_ALMACEN_GRANOS,
        EN_PROCESAMIENTO,
        FINALIZADO
    }

    public LoteCacao() {
    }

    public LoteCacao(String codigoLote, LocalDate fechaCosecha, LocalDate fechaRecepcion,
                     Proveedor proveedor, CajonFermentacion cajon, String variedad, Double pesoBabaKg) {
        this.codigoLote = codigoLote;
        this.fechaCosecha = fechaCosecha;
        this.fechaRecepcion = fechaRecepcion;
        this.proveedor = proveedor;
        this.cajon = cajon;
        this.variedad = variedad;
        this.pesoBabaKg = pesoBabaKg;
        this.estado = EstadoLote.RECEPCIONADO;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
        if (this.estado == null) {
            this.estado = EstadoLote.RECEPCIONADO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public CajonFermentacion getCajon() {
        return cajon;
    }

    public void setCajon(CajonFermentacion cajon) {
        this.cajon = cajon;
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

    public EstadoLote getEstado() {
        return estado;
    }

    public void setEstado(EstadoLote estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
