/**
 * 
 */
package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Mehul
**/

@Entity
@Table(name = "location_master")
@Data
public class Location {

	@Id
	@GeneratedValue
	private int locationId;
	private String locationName;
	
}
