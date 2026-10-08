package com.cacaormpresa.cacaormpresa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "libre")
public class Libre {
	@Id
	private String idlibre;
//getter
	public String getidlibreria(){
return this.idlibre;
}

//setter
public void setidlibreria(String idlibre){ this.idlibre = idlibre;}
     
	private String slote1;
    private String slote2;
    private String slote3;
    private String slote4;

    public Libre(){}
/// get
    public String Entrada(int i){
        switch (i){
            case 0:
                return this.slote1;

            case 1:
                return this.slote2;

            case 2:
                return this.slote3;

            case 3:
                return this.slote4;

            default:
            return "Error de entrega ";






        }


    }




    /// set
    public void Modificacion (int i, String Entrega){
        switch (i){
            case 0:
                 this.slote1 = Entrega;
break;
            case 1:
                 this.slote2 = Entrega;
break;
            case 2:
              this.slote3 = Entrega;
break;
            case 3:
          this.slote4 = Entrega;
break;
            default:
           System.out.print("Error de entrga ");






        }


    }

    public String getIdlibre() {
        return idlibre;
    }

    public void setIdlibre(String idlibre) {
        this.idlibre = idlibre;
    }

    public String getSlote1() {
        return slote1;
    }

    public void setSlote1(String slote1) {
        this.slote1 = slote1;
    }

    public String getSlote2() {
        return slote2;
    }

    public void setSlote2(String slote2) {
        this.slote2 = slote2;
    }

    public String getSlote3() {
        return slote3;
    }

    public void setSlote3(String slote3) {
        this.slote3 = slote3;
    }

    public String getSlote4() {
        return slote4;
    }

    public void setSlote4(String slote4) {
        this.slote4 = slote4;
    }

    
    
    /////Almacenamiento completo de compativilidad

    
}
