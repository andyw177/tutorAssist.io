package com.se785.TutorAssist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.se785.TutorAssist.models.Rating;
import com.se785.TutorAssist.services.RatingService;
import com.se785.TutorAssist.services.StudentService;

//Andy Wang 
@RestController
@RequestMapping("/ratings")
public class RatingsController {
private RatingService rs;
@Autowired
private StudentService ss;
	
	@Autowired
	public RatingsController(RatingService rs) {
		super();
		this.rs = rs;
	}
	// Test Route
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
	 //Creates a new User entry in the database using the given information.
    @PostMapping(value="/create")
    public HttpStatus createRequest(@RequestParam(name = "tutor") int tutorId, @RequestParam(name = "rating") int rating) {
    	//getting the logged in user info
    	User current_user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    	int studentId = ss.getStudentByUsername(current_user.getUsername()).getStudentId();
    	rs.createRating(tutorId,rating,studentId);
		return HttpStatus.OK;
    }
    
    //Updates a Users entry in the database using the given information.
    @PostMapping(value="/update")
    public ResponseEntity<String> updateRequest(@RequestBody Rating rating){
		if(rs.updateRating(rating)) {
			return new ResponseEntity<>("Update successful", HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Update unsuccessful", HttpStatus.BAD_REQUEST); 
		}
	}
    
    //Deletes a Users entry in the database using the given information.
    @PostMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
    	if(rs.deleteRating(id)) {
			return new ResponseEntity<>("Delete successful" , HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
    
	//Provides a Users on the database that matches a given criteria and sends it back as JSON.
    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
    	Rating rating = rs.getRatingById(id);
    	if(rating == null) {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(rating,HttpStatus.OK); 
		}
    }

    
    @PostMapping(value="/rate/{id}")
    public ResponseEntity<String> RateAverage(@PathVariable("id") int id) {
    	if(rs.setAverageRating(id)) {
			return new ResponseEntity<>("Average set successfully" , HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
	    
}
