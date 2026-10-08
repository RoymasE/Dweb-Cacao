package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "proceso")
public class Proceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int procesoid;
	
	
	
	private boolean moho;
private boolean humedad;
private int gradodefermentacion;

public Proceso(){}
    /// Entregar get
    public boolean Entregar(int i) {
        switch (i) {
            case 1:
                return this.moho;
            case 2:
                return this.humedad;
            default:
                System.out.println("Error de consulta ");
                                   return false;

        }

    }

    public int getunico(){
        return this.gradodefermentacion;
    }



        //setter
public <T> void Modificar(T Entrega, int i){

        switch (i){
            case 1:
                this.gradodefermentacion = (int)Entrega;
                break;
            case 2:
                this.moho = (boolean)Entrega;
                break;
            case 3:
                this.humedad = (boolean) Entrega;
                break;
            default:
                System.out.print("Error");



        }




}



/////Almacenamiento completo de compativilidad

//con almacen 
private Almacen almacen;

    public int getProcesoid() {
        return procesoid;
    }

    public void setProcesoid(int procesoid) {
        this.procesoid = procesoid;
    }

    public boolean isMoho() {
        return moho;
    }

    public void setMoho(boolean moho) {
        this.moho = moho;
    }

    public boolean isHumedad() {
        return humedad;
    }

    public void setHumedad(boolean humedad) {
        this.humedad = humedad;
    }

    public int getGradodefermentacion() {
        return gradodefermentacion;
    }

    public void setGradodefermentacion(int gradodefermentacion) {
        this.gradodefermentacion = gradodefermentacion;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }



}
