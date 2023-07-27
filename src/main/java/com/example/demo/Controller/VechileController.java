package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.VechileServices;
import com.example.demo.module.Vechile;

@RestController
public class VechileController 
{
	@Autowired
	VechileServices services;
	
	//localhost:8081/addvechile
	@PostMapping("/addvechile")
	ResponseEntity<Vechile> addVechile(@RequestBody Vechile v)
	{
		return new ResponseEntity<Vechile>(services.addVechile(v),HttpStatus.CREATED);
		
	}
	//localhost:8081/getById
	@GetMapping("/getById")
	ResponseEntity<Vechile> getById(@RequestHeader Integer vid)
	{
		return  new ResponseEntity<Vechile>(services.getById(vid),HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getBycolor")
	ResponseEntity<List<Vechile>> getBycolor(@RequestHeader String vcolor)
	{
		return  new ResponseEntity<List<Vechile>>(services.getByVcolour(vcolor),HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/deleate")
	ResponseEntity<Vechile> deleatById(@RequestHeader Integer vid)
	{
		return new ResponseEntity<Vechile>(services.deleteById(vid),HttpStatus.OK);
	}
	
	@GetMapping("/getByprice")
	ResponseEntity<List<Vechile>> getByprice(@RequestHeader Double vprice)
	{
		return  new ResponseEntity<List<Vechile>>(services.getPriceGreaterThan(vprice),HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getBysorted")
	ResponseEntity<List<Vechile>> getBysorting()
	{
		return  new ResponseEntity<List<Vechile>>(services.getSortedPrice(),HttpStatus.FOUND);
		
	}
	@PutMapping("/update")
	
	ResponseEntity<Vechile> update(@RequestBody Vechile v)
	{
		return new ResponseEntity<Vechile>(services.updateVechile(v),HttpStatus.OK);
		
	}
	@GetMapping("/getallvechile")
	ResponseEntity<List<Vechile>> getallvechile()
	{
		return  new ResponseEntity<List<Vechile>>(services.getAllVehicle(),HttpStatus.ACCEPTED);
		
	}
	

}
