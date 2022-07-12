package com.house.example.house;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.model.House;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HouseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;
	
	private String getRootUrl() {
        return "http://localhost:" + port;
    }
	
	@Test	
	void contextLoads() {		
	}
	
		
	@Test
	public void saveHouseTest() {
		House house = new House();
		house.setHouseAddress("test");
		house.setOwner("Mani");
		ResponseEntity<House> postResponse = restTemplate.postForEntity(getRootUrl() + "/house", house, House.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
	}
	
	@Test
    public void getHouseTest() {
		House house = restTemplate.getForObject(getRootUrl() + "/houses", House.class);
        assertNotNull(house);
    }
	
}
