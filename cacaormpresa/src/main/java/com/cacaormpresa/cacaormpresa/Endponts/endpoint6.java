package com.cacaormpresa.cacaormpresa.Endponts;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacaormpresa.cacaormpresa.Entity.Trabajadores;
import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;


// Trabajadores´ topic 
@RestController 
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