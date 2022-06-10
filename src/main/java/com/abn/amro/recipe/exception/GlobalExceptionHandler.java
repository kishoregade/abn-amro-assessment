package com.abn.amro.recipe.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import com.abn.amro.recipe.util.Utility;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle Specific Exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request ){
	      
	  ErrorDetails errorDetails =  new ErrorDetails(Utility.getDate(),request.getDescription(false), exception.getMessage());
	  return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);	  
  }
	
  // Handle Global Exceptions
	@ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request ){ 
	  ErrorDetails errorDetails =  new ErrorDetails(Utility.getDate().toString(),request.getDescription(false), exception.getMessage());
	  return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);	  
 }
  
}
