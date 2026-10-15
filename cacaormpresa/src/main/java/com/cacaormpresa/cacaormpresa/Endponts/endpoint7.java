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


// Transporte´ topic 
@Controller 
@RequesMapping("/api/crud/7")
public class endpoint7 extends Madreendponits{
	
		//Create one 
	@PostMapping("/create/")
	//Update one 
	@PutMapping("/update/")
	//Read one 
	@GetMapping("/readone/{id}")
	//Read all
	@GetAllMapping("/readall")
	//delete one 
	@DeleteMapping("/delete/{id}")
	
}