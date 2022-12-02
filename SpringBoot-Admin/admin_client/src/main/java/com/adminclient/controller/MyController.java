package com.adminclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminclient.exception.RollNumberNotFound;
import com.adminclient.model.Student;
import com.adminclient.repository.StudentRepository;
import com.adminclient.service.StudentService;

@RestController
public class MyController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String home() {
		return ("Home Page");
	}

	// method for save Student data into database
	@PostMapping("/save")
	public Student saveData(@RequestBody Student data) {
		return this.studentService.AddData(data);

	}

	// method for get all student data from db
	@GetMapping("/getalldata")
	public List<Student> getAllData() {
		return this.studentRepository.findAll();
//		if(studentRepository.findAll().isEmpty()) {
//			
//		}

	}
	
	
	//method for find Student Details by RollNumber
	
	@GetMapping("/getbyrollnumber")
	public ResponseEntity<List<Student>> getDetailsByRollNumber(@RequestParam int rollnumber) throws RollNumberNotFound {
		//trying to use custom exception
		if(studentRepository.findByRollnumber(rollnumber).isEmpty()) {
			throw new RollNumberNotFound("RollNumber does not exist !!");
		}else
		return new ResponseEntity<List<Student>>(studentRepository.findByRollnumber(rollnumber), HttpStatus.OK);
	}
	
}
