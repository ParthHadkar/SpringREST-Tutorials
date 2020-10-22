package com.Jackson_databindJson;

import java.io.File;
import java.io.IOException;

import com.Jackson_databindJson.model.Address;
import com.Jackson_databindJson.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver 
{
    public static void main( String[] args )
    {
    	try {
			// create objectMapper object
			ObjectMapper objectMapper = new ObjectMapper();
			// read the json object from the file and map/convert to Java Pojo
			Student student = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			// print student details
			System.out.println("Id : "+student.getId());
			System.out.println("First Name : "+student.getFirstName());
			System.out.println("Last Name : "+student.getLastName());
			System.out.println("Active : "+student.isActive());
			// get address from student
			Address address = student.getAddress();
			System.out.println("Street : "+address.getStreet());
			System.out.println("City : "+address.getCity());
			System.out.println("State : "+address.getState());
			System.out.println("Zip : "+address.getZip());
			System.out.println("Country : "+address.getCountry());
			// display array of languages
			for(String tempObj:student.getLanguages()) {
				System.out.println("Languages : "+tempObj);
			}
			
			
		}   catch (Exception e) {
			e.printStackTrace();
		}
        
        
    }
}
