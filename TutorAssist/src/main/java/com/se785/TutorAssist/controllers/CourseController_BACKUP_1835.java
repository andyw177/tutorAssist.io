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
import org.springframework.web.bind.annotation.RequestParam;
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
		 //Creates a new Course entry in the database using the given information.
	    @PostMapping(value="/create")
	    public HttpStatus createRequest(@RequestBody Course course) {
	    	cs.createCourse(course);
			return HttpStatus.OK;
	    }
	    
	    //Updates a Course entry in the database using the given information.
	    @PutMapping(value="/update")
	    public ResponseEntity<String> updateRequest(@RequestBody Course course){
			if(cs.updateCourse(course)) {
				return new ResponseEntity<>(HttpStatus.OK); 
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
		}
	    
	    //Deletes a Course entry in the database using the given information.
	    @DeleteMapping(value="/delete/{id}")
	    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
	    	if(cs.deleteCourse(id)) {
				return new ResponseEntity<>(HttpStatus.OK); 
			}else {
<<<<<<< HEAD
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}s
=======
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
>>>>>>> d764cc34d35fce34fc643b9af7520d2152750e63
	    }
	    
		//Provides a Course on the database that matches a given criteria and sends it back as JSON.
	    @GetMapping(value="/get/{id}")
	    public ResponseEntity<Course> getRequest(@PathVariable("id") int id) {
	    	Course course = cs.getByCourseid(id);
	    	if(course == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}else {
				return new ResponseEntity<>(course,HttpStatus.OK); 
<<<<<<< HEAD
=======
			}
	    }
	    
	    //Providing user ability to enroll in the course 
	    @PutMapping(value = "/enroll")
	    public ResponseEntity<String> enrollClass(@RequestParam("class") int classId, @RequestParam("student") int studentId) {
	    	if(cs.enroll(classId,studentId)) {
	    	return new ResponseEntity<>(HttpStatus.OK); 
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
>>>>>>> d764cc34d35fce34fc643b9af7520d2152750e63
			}
	    	
	    }
	
	
	
}