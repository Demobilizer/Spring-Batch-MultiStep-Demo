/**
 * 
 */
package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Location;

/**
 * @author Mehul
**/

@Repository
public interface LocationDao extends JpaRepository<Location, Integer> {

	/**
	 * @param locationName
	 */
	public Location findByLocationName(String locationName);

	/**
	 * 
	 */
	@Query(value = "SELECT location_id FROM location_master", nativeQuery = true)
	public List<Integer> findAllLocationIds();

}
