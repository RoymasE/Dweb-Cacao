package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "record")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordid;
//chimera ..........
	public int chimera10(int i){
	
	if (i >= 0){
	this.recordid = i;
		return -99999;
	}else{
	return this.recordid;
	
	}
	
	}
	
	
	
	
	
private double peso;
	private boolean ensascado;


//setter and getter
//--setter
//
public void setterate(double peso){
this.peso = peso;
}

public void setterate(boolean ensacado){
this.ensascado =ensacado;

}


// -- getter
public double entrega(int i){
return this.peso;
}

public boolean entrega(){
return this.ensascado;
}



//////
///
///
 
public Record(){



}

    public int getRecordid() {
        return recordid;
    }

    public void setRecordid(int recordid) {
        this.recordid = recordid;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isEnsascado() {
        return ensascado;
    }

    public void setEnsascado(boolean ensascado) {
        this.ensascado = ensascado;
    }
/////Almacenamiento completo de compativilidad





}
