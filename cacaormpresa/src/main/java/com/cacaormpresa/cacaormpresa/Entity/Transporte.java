package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "transporte")
public class Transporte {
	
	@Id
	private String idtransporte;
	//Getter
	public String getidt(){
	
	return this.idtransporte;
	
	}
	//Setter 
	public void setidt(String transporte){
	this.idtransporte = transporte;
	
	}
	
	
	
	
	
	//0--> fecha entrada del cacao de entrada 1--> fecha salida del cacao //procesado 
	private String[] a = new String[2];
	private String compradordecaco;
	private double preciodetransporte;
	private double kgtransportados;
	private double preciodecompra;
	
	

	
	//Entrega get 
	public String[] getstring(){
	return new String[] {this.compradordecaco, this.a[0], this.a[1]}; 
	
	
	}
	
	//Entrega de transporte 1 
	public double entrega1(){
	return this.preciodetransporte;
	}
	
	//Entrega de los kilogramos de transporte 
	public double getkgtransporte()
	{
	return this.kgtransportados;
	
	}
	//entrega3 
//Entrega de precio de venta osea lo planteado para vender 
	public double entrega3(){
	return this.preciodecompra;
	
	}
	//##########################
	//##########################
	
	//##########################
	
	//##########################
	
	//##########################
	//setter 
	public void modificacio(int i, String palabra, String[] lista, double numero){
	
	switch(i){
		case 1:
			///------------
			///a[0] = fecha de entrada del cacao 
			///a[1] == fecha de salida del cacao (ya cuando se proceso)
			///
			////
			////---------
	this.a[0] =		palabra;
			break;
		case 2:
			
			///------------
			///a[0] = fecha de entrada del cacao 
			///a[1] == fecha de salida del cacao (ya cuando se proceso)
			///
			////
			////---------
			this.a[1]= palabra;
			break;
			
		case 3:
			this.compradordecaco = palabra;
			break;
			
		case 4:
		this.kgtransportados = numero;
			break;
		
		case 5:
		this.preciodecompra = numero;
			break;
		
		case 6:
		
			break;
		
		
		
		
		case 8:
		
			break;
		
		
		default:
			System.out.println("Error *-*");
	
	}
	}
	
	
	public Transporte(){}
	/////Almacenamiento completo de compativilidad

        
        @ManyToMany(mappedBy = "L2")
        private Record record;

    public String getIdtransporte() {
        return idtransporte;
    }

    public void setIdtransporte(String idtransporte) {
        this.idtransporte = idtransporte;
    }

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String getCompradordecaco() {
        return compradordecaco;
    }

    public void setCompradordecaco(String compradordecaco) {
        this.compradordecaco = compradordecaco;
    }

    public double getPreciodetransporte() {
        return preciodetransporte;
    }

    public void setPreciodetransporte(double preciodetransporte) {
        this.preciodetransporte = preciodetransporte;
    }

    public double getKgtransportados() {
        return kgtransportados;
    }

    public void setKgtransportados(double kgtransportados) {
        this.kgtransportados = kgtransportados;
    }

    public double getPreciodecompra() {
        return preciodecompra;
    }

    public void setPreciodecompra(double preciodecompra) {
        this.preciodecompra = preciodecompra;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
        
    
 
    
}
