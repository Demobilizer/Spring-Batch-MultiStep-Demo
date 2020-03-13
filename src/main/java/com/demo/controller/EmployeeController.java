/**
 * 
 */
package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.repo.EmployeeDao;

/**
 * @author Mehul
**/

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@PostMapping("/save-employee")
	public String saveUser(@RequestBody Employee employee) {
		employee.setLocation(locationDao.findByLocationName(employee.getLocation().getLocationName()));
		employeeDao.save(employee);
		return "Emp added successfully!";
	}
	
}
