/**
 * 
 */
package com.demo.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.demo.batch.mapper.EmployeeMapper;
import com.demo.model.Employee;
import com.demo.repo.EmployeeDao;
import com.demo.repo.LocationDao;

/**
 * @author Mehul
**/

@Configuration
public class LocationWiseEmployeeReader implements ItemReader<List<Employee>> {
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	List<Integer> locationIdList = new ArrayList<>();
	
	/*
	 * private static final String QUERY_FIND_EMPLOYEES_BY_ID = "SELECT " +
	 * "emp_id, " + "emp_name, " + "salary, " + "location_id " + "FROM emp_master "
	 * + "WHERE location_id = ?";
	 * 
	 * private static final String QUERY_TO_GET_IDs = "SELECT "+ "location_id "+
	 * "FROM location_master";
	 */
	
	public List<Integer> getLocationIds() {
		System.out.println("findAllLocationId ----- "+locationDao.findAllLocationIds());
		return locationDao.findAllLocationIds();
	}
	
	public List<Employee> getEmpListForEachLocationId() {
		
		locationIdList = getLocationIds();
		System.out.println("locationIdList"+locationIdList);
		
		//System.out.println("employeeDao.findByLocation(locationIdList): "+employeeDao.findByLocation(locationIdList));
		
		return employeeDao.findByLocation(locationIdList);
	}

	@Override
	@StepScope
	public List<Employee> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("employeeDao.findByLocation(locationIdList): "+employeeDao.findByLocation(locationIdList));
		return employeeDao.findByLocation(locationIdList);
	}
	
	/*
	 * @Bean ItemReader<Integer> empReader(DataSource dataSource) {
	 * JdbcCursorItemReader<Integer> databaseReader = new JdbcCursorItemReader<>();
	 * 
	 * databaseReader.setDataSource(dataSource);
	 * databaseReader.setSql(QUERY_TO_GET_IDs); databaseReader.setRowMapper(new
	 * BeanPropertyRowMapper<>(Integer.class));
	 * 
	 * return databaseReader; }
	 */
	
	/*
	 * @Bean ItemReader<Employee> empReader(DataSource dataSource) {
	 * JdbcCursorItemReader<Employee> databaseReader = new JdbcCursorItemReader<>();
	 * 
	 * locationIdList = getLocationIds();
	 * 
	 * for (Integer locationId : locationIdList) {
	 * 
	 * databaseReader.setDataSource(dataSource);
	 * databaseReader.setSql(QUERY_FIND_EMPLOYEES_BY_ID);
	 * databaseReader.setPreparedStatementSetter(new PreparedStatementSetter() {
	 * public void setValues(PreparedStatement preparedStatement) throws
	 * SQLException { preparedStatement.setInt(1, locationId); } });
	 * databaseReader.setRowMapper(new EmployeeMapper());
	 * 
	 * }
	 * 
	 * return databaseReader; }
	 */
	
}
