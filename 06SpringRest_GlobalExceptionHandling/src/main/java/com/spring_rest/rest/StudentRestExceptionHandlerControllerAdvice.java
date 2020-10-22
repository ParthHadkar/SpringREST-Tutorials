package com.spring_rest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring_rest.rest.exception.StudentErrorResponse;
import com.spring_rest.rest.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandlerControllerAdvice {

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
