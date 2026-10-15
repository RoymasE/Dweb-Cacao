package com.cacaormpresa.cacaormpresa.Endponts;

import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cacaormpresa.cacaormpresa.Entity.Record;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


// Record´ topic 
@Controller 
@RequestMapping("/api/crud/5")
public class endpoint5 extends Madreendponits{
	public endpoint5(servicio s){
        super(s);
    }
		//Create one 
	@PostMapping("/create/")
    public void createRecord(@RequestBody Record record){
        s.crear1record(record);
    }
	//Update one 
	@PutMapping("/update/")
    public void updateRecord(@RequestBody Record record){
        s.actualizacion1record(record.getRecordid(), record);
    }

	//Read one 
	@GetMapping("/readone/{id}")
    public Record readOneRecord(@RequestBody Record record){
        return s.lista1uno1record(record.chimera10(-1));
    }
	//Read all
	@GetMapping("/readall")
    public List<Record> getAllRecord(){
        return s.listar1record();
    }


	//delete one 
	@DeleteMapping("/delete/{id}")
	public void deleteRecord(@PathVariable int id){
        s.eliminar1record(id);
    }
	
}