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

import com.cacaormpresa.cacaormpresa.Entity.Libre;
import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;


// Libre´ topic 
@RestController 
@RequestMapping("/api/crud/4")
public class endpoint4 extends Madreendponits{
    public endpoint4(servicio s){
        super(s);
    }

		//Create one 
	@PostMapping("/create/")
    public void createlibre(@RequestBody Libre libre ){
        s.crear1reguistrolibre(libre);

    }

	//Update one 
	@PutMapping("/update/")
    public void updatelibre(@RequestBody Libre libre ){
        s.actualizar1libre(libre.getIdlibre(),libre);

    }
	//Read one 
	@GetMapping("/readone/{id}")
public Libre GetOneLibre(@PathVariable String id){
    return     s.listar1uno1libre(id);
    }
	//Read all
	@GetMapping("/readall")
    public List<Libre> getAllLibre(){

        return s.listarlibre();

    }

	//delete one 
	@DeleteMapping("/delete/{id}")
    public void deleteLibre(@PathVariable String id){
        s.eliminar1libre(id);
    }
	
	
}