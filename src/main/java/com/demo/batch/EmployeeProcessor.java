/**
 * 
 */
package com.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.demo.model.Employee;
import com.demo.model.NewEmployee;

/**
 * @author Mehul
**/

public class EmployeeProcessor implements ItemProcessor<List<Employee>, NewEmployee>{

	//@Override
	//public NewEmployee process(Employee employee) throws Exception {

		/*
		 * NewEmployee newEmployee = new NewEmployee();
		 * 
		 * newEmployee.setEmpName(employee.getEmpName());
		 * newEmployee.setLocation(employee.getLocation().getLocationName());
		 * newEmployee.setSalary(employee.getSalary());
		 */
		
		//return null;
	//}

	@Override
	public NewEmployee process(List<Employee> item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
