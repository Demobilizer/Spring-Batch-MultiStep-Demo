/**
 * 
 */
package com.demo.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Employee;
import com.demo.model.Location;

/**
 * @author Mehul
**/

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("emp_id"));
		employee.setEmpName(rs.getString("emp_name"));
		employee.setSalary(rs.getInt("salary"));
		employee.setLocation(rs.getObject(4, Location.class));
		return employee;
	}

}
