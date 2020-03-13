/**
 * 
 */
package com.demo.batch;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import com.demo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Mehul
**/

public class LocationWiseEmployeeReader {
	
	ChunkContext chunkContext;
		
		@Bean
		@StepScope 
		JsonItemReader<Employee> jsonItemReader() throws IOException {
			
			List<Employee> empList = (List<Employee>) chunkContext
					.getStepContext()
					.getStepExecution()
					.getJobExecution()
					.getExecutionContext()
					.get("employeeListByLoactionId");
			
			ObjectMapper objectMapper = new ObjectMapper();
			// configure the objectMapper as required
			JacksonJsonObjectReader<Employee> jsonObjectReader = new JacksonJsonObjectReader<>(Employee.class);
			jsonObjectReader.setMapper(objectMapper);
			
			Gson gson = new Gson();
			Type type = new TypeToken<List<Employee>>() {}.getType();
			String json = gson.toJson(empList, type);
			byte[] bytes = json.getBytes();
			
			Resource resource = new ByteArrayResource(bytes);
			
			return new JsonItemReaderBuilder<Employee>()
					.jsonObjectReader(jsonObjectReader)
					.resource(resource)
					.name("Student marks reader")
					.build();
		}
		

}
