/**
 * 
 */
package com.demo.batch;

import org.springframework.batch.item.ItemProcessor;

import com.demo.model.Employee;
import com.demo.model.NewEmployee;

/**
 * @author Mehul
**/

public class EmployeeProcessor implements ItemProcessor<Employee, NewEmployee>{

	@Override
	public NewEmployee process(Employee employee) throws Exception {

		NewEmployee newEmployee = new NewEmployee();
		
		newEmployee.setEmpName(employee.getEmpName());
		newEmployee.setLocation(employee.getLocation().getLocationName());
		newEmployee.setSalary(employee.getSalary());
		
		return newEmployee;
	}

	
}
