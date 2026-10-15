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



@Controller 
@RequesMapping("/api/crud/1")
public class endpoint1 extends Madreendponits{
	
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
		s.eliminar1almaen(id);
		
	}
	
	
	//Buscar uno
	//Find one 
	@GetMapping("/findone/{id}")
	public Almacen GetOneAlmacen(@PathVariable String id){
		
		s.listar1uno1almacen(id);
		
	}
	
}
