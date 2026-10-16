package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombreCompleto;

    @Column(nullable = false, unique = true, length = 20)
    private String dniRuc;

    @Column(nullable = false, length = 100)
    private String comunidadSector; // ej. Huicungo, Tocache, Juanjuí (Región San Martín)

    @Column(length = 150)
    private String parcelaOrigen;

    @Column(length = 50)
    private String codigoContratoComunal;

    @Column(length = 30)
    private String telefono;

    private Double hectareas;

    @Column(nullable = false)
    private Boolean activo = true;

    private LocalDateTime fechaRegistro;

    public Proveedor() {
    }

    public Proveedor(String nombreCompleto, String dniRuc, String comunidadSector, String parcelaOrigen,
                     String codigoContratoComunal, String telefono, Double hectareas) {
        this.nombreCompleto = nombreCompleto;
        this.dniRuc = dniRuc;
        this.comunidadSector = comunidadSector;
        this.parcelaOrigen = parcelaOrigen;
        this.codigoContratoComunal = codigoContratoComunal;
        this.telefono = telefono;
        this.hectareas = hectareas;
        this.activo = true;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
        if (this.activo == null) {
            this.activo = true;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getComunidadSector() {
        return comunidadSector;
    }

    public void setComunidadSector(String comunidadSector) {
        this.comunidadSector = comunidadSector;
    }

    public String getParcelaOrigen() {
        return parcelaOrigen;
    }

    public void setParcelaOrigen(String parcelaOrigen) {
        this.parcelaOrigen = parcelaOrigen;
    }

    public String getCodigoContratoComunal() {
        return codigoContratoComunal;
    }

    public void setCodigoContratoComunal(String codigoContratoComunal) {
        this.codigoContratoComunal = codigoContratoComunal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getHectareas() {
        return hectareas;
    }

    public void setHectareas(Double hectareas) {
        this.hectareas = hectareas;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
