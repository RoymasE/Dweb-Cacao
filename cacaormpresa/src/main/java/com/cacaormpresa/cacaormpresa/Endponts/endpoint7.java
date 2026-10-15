package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;


// Transporte´ topic 
@Controller 
@RequestMapping("/api/crud/7")
public class endpoint7 extends Madreendponits{
	public endpoint7(servicio s){
        super(s);
    }
		//Create one 
	@PostMapping("/create/")
    public void createTransporte(@RequestBody Transporte transporte){
        s.guardar1transporte(transporte);
    }
	//Update one 
	@PutMapping("/update/")
    public void updateTransporte(@RequestBody Transporte transporte){
        s.actualizar1transporte(transporte.getidt(), transporte);
    }
	//Read one 
	@GetMapping("/readone/{id}")
    public Transporte getOneTransporte(@PathVariable String id){
     return    s.lista1uno1transporte(id);
    }
	//Read all
	@GetMapping("/readall")
    public List<Transporte> getAllTrnasporte(){
        return s.listar1transporte();
    }

	//delete one 
	@DeleteMapping("/delete/{id}")
   public void deleteTransporte(@PathVariable String id){
        s.eliminar1transporte(id);
    }
	
}