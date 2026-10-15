package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;


// Trabajadores´ topic 
@Controller 
@RequestMapping("/api/crud/6")
public class endpoint6 extends Madreendponits{
	public endpoint6(servicio s){
        super(s);
    }
		//Create one 
	@PostMapping("/create/")
    public void createTrabajadores(@PathVariable Trabajadores trabajadores){
        s.crear1trabajador(trabajadores);
    }
	//Update one 
	@PutMapping("/update/")
    public void updateTrabajadores(@RequestBody Trabajadores trabajadores){
        s.Actualizar1trabjadador(trabajadores.getIdTrabajadores(), trabajadores);
    }
	//Read one 
	@GetMapping("/readone/{id}")
    public Trabajadores readOneTrabajadores(@PathVariable String id){
        return s.listar1uno1trabajador(id);
    }
	//Read all
	@GetMapping("/readall")
    public List<Trabajadores> readAllTrabajadores(){
        return s.listar1trabajadores();
    }



	//delete one 
	@DeleteMapping("/delete/{id}")
    public void deleteTrabajador(@PathVariable String id){
        s.Elminar1trabajador(id);
    }
	
}