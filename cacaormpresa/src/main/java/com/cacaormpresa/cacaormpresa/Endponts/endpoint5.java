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

import com.cacaormpresa.cacaormpresa.Entity.Record;
import com.cacaormpresa.cacaormpresa.deseodeinterfas.servicio;


// Record´ topic 
@RestController 
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