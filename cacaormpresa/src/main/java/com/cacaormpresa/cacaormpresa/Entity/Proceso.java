package com.cacaormpresa.cacaormpresa.Entity;

public class Proceso {
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







}
