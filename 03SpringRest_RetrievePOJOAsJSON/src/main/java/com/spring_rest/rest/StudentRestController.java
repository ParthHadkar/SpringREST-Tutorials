package com.spring_rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_rest.model.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	// define @PostConstructor to load student data only once
	@PostConstruct
	public void loadStudents() {
		students = new ArrayList<Student>();
		students.add(new Student("Parth","Hadkar"));
		students.add(new Student("Nikhil","Etame"));
		students.add(new Student("Omkar","Pednekar"));
		students.add(new Student("Deepak","Pejale"));
	}
	
	// define endpoint for "/students" - return list of students
	// not a best practice to write /viewStudents (actions) instead use http methods for REST
	@GetMapping("/students")
	public List<Student> getStudents(){	
		return students;
	}
}
