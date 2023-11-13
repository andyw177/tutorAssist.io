package com.se785.TutorAssist.controllers;

import java.util.Map;
import java.util.Set;

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

import com.se785.TutorAssist.exceptions.UserNotFoundException;
import com.se785.TutorAssist.models.Class;
import com.se785.TutorAssist.models.Tutor;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.services.TutorService;

@RestController
@RequestMapping("/tutor")
public class TutorController {
	private TutorService ts;
	
	@Autowired
	public TutorController(TutorService ts) {
		super();
		this.ts = ts;
	}
	
	// Test Route
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
	 //Creates a new User entry in the database using the given information.
    @PostMapping(value="/create")
    public HttpStatus createRequest(@RequestBody Tutor tutor) {
    	ts.createTutor(tutor);
		return HttpStatus.CREATED;
    }
    
    //Updates a Users entry in the database using the given information.
    @PutMapping(value="/update")
    public ResponseEntity<String> updateRequest(@RequestBody Tutor Tutor) throws UserNotFoundException {
		if(ts.updateTutor(Tutor)) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED); 
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
    
    //Deletes a Users entry in the database using the given information.
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) throws UserNotFoundException {
    	if(ts.deleteTutor(id)) {
			return new ResponseEntity<>(HttpStatus.FOUND); 
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
    }
    
	//Provides a Users on the database that matches a given criteria and sends it back as JSON.
    @GetMapping(value="/get/{id}")
    public ResponseEntity<Tutor> getRequest(@PathVariable("id") int id) throws UserNotFoundException {
    	Tutor Tutor = ts.getTutorById(id);
    	if(Tutor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}else {
			return new ResponseEntity<>(Tutor,HttpStatus.FOUND); 
		}
    }
    
	//Provides a list of Clatses on the database that match a given criteria and sends it back as JSON.
    @GetMapping(value="/getClasses/{id}")
    public ResponseEntity<Set<Class>> getClatsList(@PathVariable("id") int id)throws UserNotFoundException {
		return new ResponseEntity<>(ts.getClassList(id),HttpStatus.FOUND); 
	
    }

	//Provides the information of every single Tutor on the database and sends it back as JSON.
    @GetMapping(value="/getTutors")
    public ResponseEntity<Set<Tutor>> getTutorList() throws UserNotFoundException {
    	return new ResponseEntity<>(ts.getAllTutors(),HttpStatus.FOUND); 
    }
    
    //Provides a list of Tutors on the database that match a given criteria and sends it back as JSON.    @GetMapping(value="/getTutors/{id}")
    @GetMapping(value="/getStudents/{id}")
    public ResponseEntity <Map<String, Set<Student>>> getStudentList(@PathVariable("id") int id) throws UserNotFoundException {
    	return new ResponseEntity<>(ts.getStudentList(id),HttpStatus.FOUND); 
    }
}
