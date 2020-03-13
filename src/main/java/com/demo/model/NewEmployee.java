/**
 * 
 */
package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Mehul
**/

@Entity
@Table(name = "new_emp_master")
@Data
public class NewEmployee {

	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	private int salary;
	private String location;
	
}
