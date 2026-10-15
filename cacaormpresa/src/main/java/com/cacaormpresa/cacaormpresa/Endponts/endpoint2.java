package com.cacaormpresa.cacaormpresa.Endponts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.list;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


// Procesos´ topic 
@Controller 
@RequesMapping("/api/crud/2")
public class endpoint2 extends Madreendponits{
	
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