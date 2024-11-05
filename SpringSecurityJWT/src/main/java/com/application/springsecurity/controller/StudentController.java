package com.application.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.springsecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	
	private List<Student> students = new ArrayList<>(List.of(
			new Student(1, "darshan", 100),
			new Student(2 , "sanju" , 9),
			new Student(3 , "liki" , 98)
			
			));
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudent(){
		return new ResponseEntity<>(students , HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/csrf")
	public CsrfToken Student(HttpServletRequest req){
		return (CsrfToken) req.getAttribute("_csrf");
		
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student){
		students.add(student);
		
		return student;
		
	}

}
