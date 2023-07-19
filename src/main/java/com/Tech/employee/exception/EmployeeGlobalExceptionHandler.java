package com.Tech.employee.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler(NameNotPresentException.class)
	public ResponseEntity<Object>noname(NameNotPresentException n){
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NameNotCaseSensitiveException.class)
			public ResponseEntity<Object>yesname(NameNotCaseSensitiveException nn){
		return new ResponseEntity<>(nn.getMessage(),HttpStatus.NOT_FOUND);
		}
	
	

}
