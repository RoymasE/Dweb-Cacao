package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cajones_fermentacion")
public class CajonFermentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String codigoCajon; // Ej: CAJ-01, CAJ-02

    @Column(nullable = false)
    private Double capacidadKg; // Ej: 500.0, 1000.0 kg

    @Column(length = 60)
    private String tipoMadera; // Ej: Laurel, Tornillo, Cedro

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoCajon estado = EstadoCajon.DISPONIBLE;

    public enum EstadoCajon {
        DISPONIBLE,
        EN_USO,
        EN_FERMENTACION,
        MANTENIMIENTO
    }

    public CajonFermentacion() {
    }

    public CajonFermentacion(String codigoCajon, Double capacidadKg, String tipoMadera) {
        this.codigoCajon = codigoCajon;
        this.capacidadKg = capacidadKg;
        this.tipoMadera = tipoMadera;
        this.estado = EstadoCajon.DISPONIBLE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCajon() {
        return codigoCajon;
    }

    public void setCodigoCajon(String codigoCajon) {
        this.codigoCajon = codigoCajon;
    }

    public Double getCapacidadKg() {
        return capacidadKg;
    }

    public void setCapacidadKg(Double capacidadKg) {
        this.capacidadKg = capacidadKg;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }

    public EstadoCajon getEstado() {
        return estado;
    }

    public void setEstado(EstadoCajon estado) {
        this.estado = estado;
    }
}
