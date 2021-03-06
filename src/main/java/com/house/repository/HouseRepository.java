package com.house.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.house.model.House;

@Repository
public interface HouseRepository extends CrudRepository<House, Long>  {
	
	}

