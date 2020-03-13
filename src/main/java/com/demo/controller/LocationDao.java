/**
 * 
 */
package com.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
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
	Location findByLocationName(String locationName);

}
