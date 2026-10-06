package com.cacaormpresa.cacaormpresa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table(name = "almacen")
public class Almacen {



    @Id
	private String idproducto;

    private String proveedor;

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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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




}
