/**
 * 
 */
package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Location;
import com.demo.repo.LocationDao;

/**
 * @author Mehul
**/

@RestController
public class LocationController {

	@Autowired
	private LocationDao locationDao;
	
	@PostMapping("/save-location")
	public String saveUser(@RequestBody Location location) {
		System.out.println("emp name--------------"+location.getLocationName());
		locationDao.save(location);
		return "Location added successfully!";
	}
}
