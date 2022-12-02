package com.adminclient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminclient.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	//find by roll numbrr
	List<Student> findByRollnumber(int name);
}
