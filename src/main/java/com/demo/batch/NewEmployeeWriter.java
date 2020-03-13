/**
 * 
 */
package com.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.NewEmployee;

/**
 * @author Mehul
**/

public class NewEmployeeWriter implements ItemWriter<NewEmployee> {

	@Autowired
	private NewEmployeeDao newEmployeeDao;
	
	@Override
	public void write(List<? extends NewEmployee> items) throws Exception {
		
		newEmployeeDao.saveAll(items);
	}

}
