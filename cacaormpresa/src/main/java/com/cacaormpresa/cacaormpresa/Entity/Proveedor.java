package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Proveedor{
private String idproveedor;
//get ID
public String getidproveedor(){
return this.idproveedor;
}
//set ID
      public void setidproveedor(String proveedor){
      
      this.idproveedor = idproveedor;
      
      } 


	private double entregenbruto;
 private int bolsasdecacao;
 private int estadodesaco;

 /// get entrega de saco 
public int entrega (int i)
{
switch(i){
	case 1: 
		return this.estadodesaco;
	case 2:
return this.bolsasdecacao;
	default:
return 0;




}



}

///-----
public double entrega(boolean a){

return this.entregenbruto;
}
//-------
//


//setter
//
//
//

    public void setEntregenbruto(double entregenbruto) {
        this.entregenbruto = entregenbruto;
    }

    public void setBolsasdecacao(int bolsasdecacao) {
        this.bolsasdecacao = bolsasdecacao;
    }

    public void setEstadodesaco(int estadodesaco) {
        this.estadodesaco = estadodesaco;
    }

    public Proveedor() {
    }



/////Almacenamiento completo de compativilidad



}
