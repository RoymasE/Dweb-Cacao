package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.cacaormpresa.cacaormpresa.Entity.*;

import org.springframework.web.bind.annotation.GetMapping;

//almacen´ topic
@Controller
@RequestMapping("/api/crud/1")
public class endpoint1 extends Madreendponits{

    public endpoint1(servicio s)
    {super(s);}
	//Mostrar
	@GetMapping("/getallalmacen")
	public List<Almacen> GetAllAlmacen(){
	return s.listar1almacen();


	}
	//Crear 
	@PostMapping("/cratealmacen/")
	public void CreateAlmacen(@RequestBody Almacen almacen){
		
		s.crear1almacen(almacen);
		
	}
	
	//Actualizar
@PutMapping("/actualizar/")
public void UpdateAlmacen(@RequestBody Almacen almacen){
	
	s.actualizar1almacen(almacen.getIdproducto(),almacen);
}
	
	//Eliminar 
	@DeleteMapping("/eliminar/{id}")
	public void DeleteAlmacen(@PathVariable String id){
		s.eliminar1almacen(id);
		
	}
	
	
	//Buscar uno
	//Find one 
	@GetMapping("/findone/{id}")
	public Almacen GetOneAlmacen(@PathVariable String id){
		
		return s.listar1uno1almacen(id);
		
	}
	
}
