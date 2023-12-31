package com.se785.TutorAssist.controllers;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.exceptions.UserNotFoundException;
import com.se785.TutorAssist.jwt.AuthenticationException;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;
import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.services.StudentService;

//Andy Wang 
@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentService ss;
	
	@Autowired
	public StudentController(StudentService ss) {
		super();
		this.ss = ss;
	}
	
	// Test Route
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
	 //Creates a new User entry in the database using the given information.
    @PostMapping(value="/create")
    public HttpStatus createRequest(@RequestBody Student stu) {
    	ss.createStudent(stu);
		return HttpStatus.OK;
    }
    
    //Updates a Users entry in the database using the given information.
    @PostMapping(value="/update")
    public ResponseEntity<String> updateRequest(@RequestBody Student student) throws UserNotFoundException {
		if(ss.updateStudent(student)) {
			return new ResponseEntity<>("Update successful" , HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Update unsuccessful" , HttpStatus.BAD_REQUEST); 
		}
	}
    
    //Deletes a Users entry in the database using the given information.
    @PostMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) throws UserNotFoundException {
    	if(ss.deleteStudent(id)) {
			return new ResponseEntity<>("Delete successful" , HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
    
	//Provides a Users on the database that matches a given criteria and sends it back as JSON.
    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> getRequest(@PathVariable("id") int id) throws UserNotFoundException {
    	Student student = ss.getStudentById(id);
    	if(student == null) {
			return new ResponseEntity<>("Id does not exist", HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(student,HttpStatus.OK); 
		}
    }
    
	//Provides a list of Coursees on the database that match a given criteria and sends it back as JSON.
    @GetMapping(value="/getCourses/{id}")
    public ResponseEntity<Set<Course>> getCourseList(@PathVariable("id") int id)throws UserNotFoundException {
		return new ResponseEntity<>(ss.getCourseList(id),HttpStatus.OK); 
	
    }

	//Provides the information of every single Student on the database and sends it back as JSON.
    @GetMapping(value="/getStudents")
    public ResponseEntity<Set<Student>> getStudentList() throws UserNotFoundException {
    	return new ResponseEntity<>(ss.getAllStudents(),HttpStatus.OK); 
    }
    
    //Provides a list of Tutors on the database that match a given criteria and sends it back as JSON.    @GetMapping(value="/getTutors/{id}")
    @GetMapping(value="/getTutors/{id}")
    public ResponseEntity<Map<String, Tutor>> getTutorList(@PathVariable("id") int id) throws UserNotFoundException {
    	return new ResponseEntity<>(ss.getTutorList(id),HttpStatus.OK); 
    }
}
