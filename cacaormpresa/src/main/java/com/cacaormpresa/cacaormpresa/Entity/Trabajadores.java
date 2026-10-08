package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "trabajador")
public class Trabajadores {
	
	public Trabajadores(){}
	
	
	@Id
private String idTrabajadores;
private String Contrasenna;
private String apellido;
private int tiempodes;
private int finserv;

//getter y setter
// getter
public 
String[]
	entrega(){
	return new String[]  {this.idTrabajadores, this.Contrasenna, this.apellido};

	
	}

public int[] entrega(int i){
return new int[] {this.tiempodes, this.finserv};
}

//setter 
//
//


public void modificacion (String Desencadena, int i ){
switch( i){
	case 1: 
		this.idTrabajadores = Desencadena;

		break;
	case 2:
		this.Contrasenna = Desencadena;
		break;
	case 3:
		this.apellido = Desencadena;
break;
	default:
System.out.print("Error :(");




}



}
	////////setter de numeros 
	public void settiempodeservicio(int i){ this.tiempodes = i;}
	public void setfindeservicio(int i){this.finserv = i;}

    public String getIdTrabajadores() {
        return idTrabajadores;
    }

    public void setIdTrabajadores(String idTrabajadores) {
        this.idTrabajadores = idTrabajadores;
    }

    public String getContrasenna() {
        return Contrasenna;
    }

    public void setContrasenna(String Contrasenna) {
        this.Contrasenna = Contrasenna;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTiempodes() {
        return tiempodes;
    }

    public void setTiempodes(int tiempodes) {
        this.tiempodes = tiempodes;
    }

    public int getFinserv() {
        return finserv;
    }

    public void setFinserv(int finserv) {
        this.finserv = finserv;
    }


/////Almacenamiento completo de compativilidad

        
        

}
