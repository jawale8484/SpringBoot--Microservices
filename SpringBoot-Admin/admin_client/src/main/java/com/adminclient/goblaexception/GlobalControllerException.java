package com.adminclient.goblaexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adminclient.exception.RollNumberAlreadyExists;
import com.adminclient.exception.RollNumberNotFound;

@ControllerAdvice
public class GlobalControllerException {

	@ExceptionHandler(RollNumberNotFound.class)
	public ResponseEntity<String> handleRollNumberNotFoundException(RollNumberNotFound rollNumberNotFound){
		return new ResponseEntity<String>("RollNumber Does not Exist !!", HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(RollNumberAlreadyExists.class)
	public ResponseEntity<String> handleRollNumberAlreadyExistException(RollNumberAlreadyExists rollNumberAlreadyExists){
		return new ResponseEntity<String>("RollNumber Already Exist !!", HttpStatus.BAD_REQUEST);
	}
	
}
