package com.adminclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminclient.exception.RollNumberAlreadyExists;
import com.adminclient.exception.RollNumberNotFound;
import com.adminclient.model.Student;
import com.adminclient.repository.StudentRepository;

@Service
public class StuduntServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student AddData(Student data) throws RollNumberAlreadyExists {
		
		if(!(studentRepository.findByRollnumber(data.getRollnumber()).isEmpty())) {
			throw new RollNumberAlreadyExists("RollNumber Already Exist !!");
		}else {
			
			studentRepository.save(data);
			return data;
		}
		
		
	}

}
