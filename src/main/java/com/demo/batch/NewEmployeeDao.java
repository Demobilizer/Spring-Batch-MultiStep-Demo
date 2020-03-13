/**
 * 
 */
package com.demo.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.NewEmployee;

/**
 * @author Mehul
**/

@Repository
public interface NewEmployeeDao extends JpaRepository<NewEmployee, Integer> {

}
