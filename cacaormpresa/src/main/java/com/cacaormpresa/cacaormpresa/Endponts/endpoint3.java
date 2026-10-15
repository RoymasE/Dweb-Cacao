package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;


// Cache´ topic 
@Controller 
@RequestMapping("/api/crud/3")
public class endpoint3 extends Madreendponits{
    public endpoint3(servicio s)
    {super(s);}



	//Create one 
	@PostMapping("/create/")
	public void createCache(@RequestBody Cache cache){
		s.crear1cache(cache);
		
	}
	//Update one 
	@PutMapping("/update/")
	public void updateCache(@RequestBody Cache cache){
		s.Actualizar1cache(cache.getCacheid(),cache);

		
		
	}
	
	//Read one 
	@GetMapping("/readone/{id}")
	public Cache getonecache(@PathVariable String id){
		return s.lisatar1uno1cache(id);
	}

	//Read all
	@GetMapping("/readall")
	public List<Cache> getallcache(){
		return s.listar1chaches();
	}
	//delete one 
	@DeleteMapping("/delete/{id}")
	public void deleteCache(@PathVariable String id){
		
		s.eliminar1cache(id);
	}
	
	
}