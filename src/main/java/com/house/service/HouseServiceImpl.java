package com.house.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.exception.ResourceNotFoundException;
import com.house.model.House;
import com.house.repository.HouseRepository;

@Service
@Transactional
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	HouseRepository houseRepository;
	
	@Override
	public List<House> getAllHouse() {
		List<House> houses = new ArrayList<House>();  
		houseRepository.findAll().forEach(house -> houses.add(house));  
			    return houses;
			    
	}

	@Override
	public House getHouseById(long id) {
		Optional<House> houseDb = this.houseRepository.findById(id);
		
		if(houseDb.isPresent()) {
			return houseDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id: "+ id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<House> houseDb = this.houseRepository.findById(id);
		
		if(houseDb.isPresent()) {
		 houseRepository.delete(houseDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id: "+ id);
		}	
	}

	@Override
	public void saveHouse(House house) {
		houseRepository.save(house); 
	}

	@Override
	public void updateHouse(House house) {
		Optional<House> houseDb = this.houseRepository.findById(house.getId());
		if(houseDb.isPresent()) {
			House updateHouse = houseDb.get();
			updateHouse.setId(house.getId());
			updateHouse.setHouseAddress(house.getOwner());
			updateHouse.setOwner(house.getOwner());
			houseRepository.save(updateHouse);
		} else {
			throw new ResourceNotFoundException("Record not found with id: "+ house.getId());
		}
	}

}
