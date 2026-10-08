package com.cacaormpresa.cacaormpresa.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "cache")
public class Cache {

@Id
public String cacheid;
public String slote1;
public String slote2;
public String slote3;
public String slote4;


public Cache(){}


    public Cache(String slote1, String slote2, String slote3, String slote4) {
        this.slote1 = slote1;
        this.slote2 = slote2;
        this.slote3 = slote3;
        this.slote4 = slote4;
    }

    public String getCacheid() {
        return cacheid;
    }

    public void setCacheid(String cacheid) {
        this.cacheid = cacheid;
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
