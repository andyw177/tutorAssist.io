package com.se785.TutorAssist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.models.Rating;
import com.se785.TutorAssist.models.Registration;
import com.se785.TutorAssist.services.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	private RegistrationService rs;

	@Autowired
	public RegistrationController(RegistrationService rs) {
		super();
		this.rs = rs;
	}
	//Test Route
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	
	@PostMapping(value = "/create")
	  public HttpStatus createRequest(@RequestBody Registration reg) {
		rs.createRegistration(reg);
		return HttpStatus.OK;
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<String> updateRequest(@RequestBody Registration reg){
		if(rs.updateRegistration(reg)) {
			return new ResponseEntity<>("Update successful", HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Update unsuccessful", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	  public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
    	if(rs.deleteRegistration(id)) {
			return new ResponseEntity<>("Delete successful",HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
	
    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
    	Registration reg= rs.getByRegistrationId(id);
    	if(reg == null) {
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}
    }
	
	@GetMapping(value = "/studentReg/{stu_id}")
	public ResponseEntity<?> studentRegistrations(@PathVariable("stu_id") int id){
		List<Registration> reg = rs.getAllByStudentId(id);
		if(reg == null){
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}
			
	}
	
	@GetMapping(value = "/pending/{tutor_id}")
	public ResponseEntity<?> pendingRegistrations(@PathVariable("tutor_id") int id){
		List<Registration> reg = rs.getAllTutorPending(id);
		if(reg == null){
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}
			
	}
    
}
