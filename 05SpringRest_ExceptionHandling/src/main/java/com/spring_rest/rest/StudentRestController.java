package com.spring_rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_rest.model.Student;
import com.spring_rest.rest.exception.StudentErrorResponse;
import com.spring_rest.rest.exception.StudentNotFoundException;

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
	
	// define endpoint for "/students{studentId}" - return student on index base
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){	
		// check studentId with list size
		if((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id Not Found : "+studentId);
		}
		return students.get(studentId);
	}
	
	// Define exception handler method with @ExceptionHandler to handle StudentNotFoundException
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		// create StudentErrorResponse object
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	// Define exception handler method with @ExceptionHandler to handle Any Exception(Generic Exception)
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			// create StudentErrorResponse object
			StudentErrorResponse errorResponse = new StudentErrorResponse();
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			errorResponse.setMessage(exc.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		}
}
