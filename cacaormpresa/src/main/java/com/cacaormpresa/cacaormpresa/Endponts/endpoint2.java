package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;


// Procesos´ topic 
@Controller 
@RequestMapping("/api/crud/2")
public class endpoint2 extends Madreendponits{

    public endpoint2(servicio s){
        super(s);
    }

	//Read whole 
	@GetMapping("/readall")
	public List<Proceso> getAllProceso(){
		return s.lista1proceso();	
	}
	//Read one 
	@GetMapping("/readone/{id}")
	public Proceso getOneProceso(@PathVariable int id ){
		
		return s.busqueda1uno1proceso(id);
	}
	
	//Create one 
	@PostMapping("/create/")
	public void createproceso(@RequestBody Proceso proceso){
		s.crear1proceso(proceso);
		
	}
	//Update one 
	@PutMapping("/update/")
	public void updateproceso(@RequestBody Proceso proceso){
		s.Actualizar1proceso(proceso.getProcesoid(), proceso);
		
	}
	//Delete one 
	@DeleteMapping("/delete/{id}")
	public void deleteproceso(@PathVariable int id){
		s.eliminar1proceso(id);
	}
	
	
	
}