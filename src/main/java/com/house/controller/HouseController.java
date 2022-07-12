package com.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.house.model.House;
import com.house.service.HouseService;

@RestController
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping("/houses")  
	private ResponseEntity<List<House>> getAllHouse() 
	{  
	return ResponseEntity.ok().body(houseService.getAllHouse());  
	} 
	
	@GetMapping("/house/{id}")  
	private ResponseEntity<House> getHouse(@PathVariable("houseId") int id)
	{  
	return ResponseEntity.ok().body(houseService.getHouseById(id));  
	}  
	
	@DeleteMapping("/house/{id}")  
	private ResponseEntity<String> deleteHouse(@PathVariable("houseId") int id)   
	{  
		houseService.delete(id);
		return ResponseEntity.ok("House info deleted"); 
	}  
	 
	@PostMapping("/house")  
	private ResponseEntity<String> saveHouse(@RequestBody House house)   
	{  
		houseService.saveHouse(house);  
	return ResponseEntity.ok("House Info Saved");
	} 
	
	@PutMapping("/house/{id}")  
	private ResponseEntity<String> updateHouse(@PathVariable("houseId") int id, @RequestBody House house)   
	{  
		house.setId(id);
		houseService.updateHouse(house);  
	return ResponseEntity.ok("House Info updated");
	} 
	
}
