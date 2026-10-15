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


// Cache´ topic 
@Controller 
@RequesMapping("/api/crud/3")
public class endpoint3 extends Madreendponits{
	//Create one 
	@PostMapping("/create/")
	public void createCache(@RequestBody Cache cache){
		
		
	}
	//Update one 
	@PutMapping("/update/")
	public void updateCache(@RequestBody Cache cache){
		
		
		
	}
	
	//Read one 
	@GetMapping("/readone/{id}")
	public Cache getonecache(@PathVariable String id){
		
	}
	//Read all
	@GetAllMapping("/readall")
	public List<Cache> getallcache(){
		
	}
	//delete one 
	@DeleteMapping("/delete/{id}")
	public void deleteCache(@PathVariable String id){
		
		
	}
	
	
}