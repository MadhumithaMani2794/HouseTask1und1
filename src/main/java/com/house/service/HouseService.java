package com.house.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.house.model.House;

@Component
public interface HouseService {

	List<House> getAllHouse();

	House getHouseById(long id);

	void delete(long id);

	void saveHouse(House house);
	
	void updateHouse(House house);

}
