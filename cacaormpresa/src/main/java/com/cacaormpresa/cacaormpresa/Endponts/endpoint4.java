package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;


// Libre´ topic 
@Controller 
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