package com.se785.TutorAssist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.services.CourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {
	private CourseService cs;
	
	@Autowired
	public CourseController(CourseService cs) {
		super();
		this.cs = cs;
	}
	// Test Route
		@GetMapping("/test")
		public String test(){
			return "Hello World";
		}
		 //Creates a new User entry in the database using the given information.
	    @PostMapping(value="/create")
	    public HttpStatus createRequest(@RequestBody Course course) {
	    	cs.createCourse(course);
			return HttpStatus.CREATED;
	    }
	    
	    //Updates a Users entry in the database using the given information.
	    @PutMapping(value="/update")
	    public ResponseEntity<String> updateRequest(@RequestBody Course course){
			if(cs.updateCourse(course)) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED); 
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
		}
	    
	    //Deletes a Users entry in the database using the given information.
	    @DeleteMapping(value="/delete/{id}")
	    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
	    	if(cs.deleteCourse(id)) {
				return new ResponseEntity<>(HttpStatus.FOUND); 
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}
	    }
	    
		//Provides a Users on the database that matches a given criteria and sends it back as JSON.
	    @GetMapping(value="/get/{id}")
	    public ResponseEntity<Course> getRequest(@PathVariable("id") int id) {
	    	Course course = cs.findByCourseid(id);
	    	if(course == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}else {
				return new ResponseEntity<>(course,HttpStatus.FOUND); 
			}
	    }
	
	
	
}
