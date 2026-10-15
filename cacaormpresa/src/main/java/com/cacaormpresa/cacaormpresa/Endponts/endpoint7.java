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

import com.cacaormpresa.cacaormpresa.Entity.Transporte;
import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;


// Transporte´ topic 
@RestController 
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