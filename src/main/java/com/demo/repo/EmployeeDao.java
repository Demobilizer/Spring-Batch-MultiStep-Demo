/**
 * 
 */
package com.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;
import com.demo.model.Location;

/**
 * @author Mehul
**/

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	/**
	 * @param findById
	 */
	List<Employee> findAllByLocation(Optional<Location> findById);

}
