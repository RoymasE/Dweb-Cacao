package com.cacaormpresa.cacaormpresa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "areas_planta")
public class AreaPlanta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre; // Ej: Acopio, Fermentación, Secado, Molienda/Procesamiento, Almacén Central

    @Column(length = 255)
    private String descripcion;

    @Column(length = 100)
    private String responsable;

    public AreaPlanta() {
    }

    public AreaPlanta(String nombre, String descripcion, String responsable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
