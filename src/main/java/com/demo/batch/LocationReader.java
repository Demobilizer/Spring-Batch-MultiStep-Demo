/**
 * 
 */
package com.demo.batch;

import java.util.List;
import java.util.Optional;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.controller.LocationDao;
import com.demo.model.Employee;
import com.demo.model.Location;
import com.demo.repo.EmployeeDao;

/**
 * @author Mehul
**/

public class LocationReader implements Tasklet {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LocationDao locationDao;
	
	private int locationId;

	public LocationReader(int locationId) {
		super();
		this.locationId = locationId;
	}
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}



	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		System.out.println("employeeListByLoactionId"+getData(getLocationId()));
		chunkContext.setAttribute("employeeListByLoactionId", getData(getLocationId()));
		
		return RepeatStatus.FINISHED;
	}

	/**
	 * @param locationId2
	 * @return 
	 */
	private List<Employee> getData(int locationId2) {
		
		return employeeDao.findAllByLocation(locationDao.findById(locationId2));
		
	}
	
	
}
