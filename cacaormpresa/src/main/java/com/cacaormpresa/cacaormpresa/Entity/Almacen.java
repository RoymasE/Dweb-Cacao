package com.cacaormpresa.cacaormpresa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table(name = "almacen")
public class Almacen {
@OneToMany(mappedBy = "L1")
    private Proceso proceso;



    @Id
	private String idproducto;



    private String tipodeproducto;
 private double precioproveedor;
    private double precioventa;
    private int catidad;


//getter y setter


    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

  

    public String getTipodeproducto() {
        return tipodeproducto;
    }

    public void setTipodeproducto(String tipodeproducto) {
        this.tipodeproducto = tipodeproducto;
    }

    public double getPrecioproveedor() {
        return precioproveedor;
    }

    public void setPrecioproveedor(double precioproveedor) {
        this.precioproveedor = precioproveedor;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }



    public Almacen(){




    }
/////Almacenamiento completo de compativilidad
    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    ///Datos de proveedor
    ///
    ///
    ///
    @ManyToMany(mappedBy = "L4")
    private Proveedor proveedor;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
@ManyToMany(mappedBy = "L3")  
private Transporte transporte;

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }



    
    

    
    
    
    
    
    
    
}
