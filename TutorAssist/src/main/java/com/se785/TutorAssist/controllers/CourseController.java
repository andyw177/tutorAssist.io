package com.se785.TutorAssist.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.jwt.AuthenticationException;
import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.services.CourseService;
import com.se785.TutorAssist.services.StudentService;

@RestController
@RequestMapping("/Course")
public class CourseController {
	private CourseService cs;
	
	@Autowired
	public CourseController(CourseService cs) {
		super();
		this.cs = cs;
	}
	
	@Autowired
	private StudentService ss;
	
	// Test Route
		@GetMapping("/test")
		public String test(){
			return "Hello World";
		}
		 //Creates a new Course entry in the database using the given information.
	    @PostMapping(value="/create")
	    public HttpStatus createRequest(@RequestBody Course course) {
	    	cs.createCourse(course);
			return HttpStatus.OK;
	    }
	    
	    //Updates a Course entry in the database using the given information.
	    @PostMapping(value="/update")
	    public ResponseEntity<String> updateRequest(@RequestBody Course course){
			if(cs.updateCourse(course)) {
				return new ResponseEntity<>("Update successful" , HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Update unsuccessful", HttpStatus.BAD_REQUEST); 
			}
		}
	    
	    //Deletes a Course entry in the database using the given information.
	    @PostMapping(value="/delete/{id}")
	    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
	    	if(cs.deleteCourse(id)) {
				return new ResponseEntity<>("Delete successful" , HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
			}
	    }
	    
		//Provides a Course on the database that matches a given criteria and sends it back as JSON.
	    @GetMapping(value="/get/{id}")
	    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
	    	Course course = cs.getByCourseid(id);
	    	if(course == null) {
				return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
			}else {
				return new ResponseEntity<>(course,HttpStatus.OK); 
			}
	    }
	   
}
