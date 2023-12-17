package com.se785.TutorAssist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.models.Message;
import com.se785.TutorAssist.models.Rating;
import com.se785.TutorAssist.models.Registration;
import com.se785.TutorAssist.services.CourseService;
import com.se785.TutorAssist.services.MessageService;
import com.se785.TutorAssist.services.RegistrationService;
import com.se785.TutorAssist.services.StudentService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	private RegistrationService rs;
	
	@Autowired
	private MessageService ms;
	@Autowired
	private StudentService ss;
	@Autowired
	private CourseService cs;

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
	
	//Create a Registration
	@PostMapping(value = "/register/{id}")
	  public ResponseEntity<String> createRequest(@PathVariable("id") int classId) {
		//getting the logged in user info
    	User current_user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	//setting sender id to the current user's id
    	if(current_user.getAuthorities().iterator().next().getAuthority()=="STUDENT") {
    		int studentId = ss.getStudentByUsername(current_user.getUsername()).getStudentId();
    		try {
				switch(rs.register(classId,studentId)){
				case "registered":
					return new ResponseEntity<>("Registration successful", HttpStatus.OK);
				case "accepted":
					return new ResponseEntity<>("Already registered to course", HttpStatus.BAD_REQUEST);
				case "pending":
					return new ResponseEntity<>("Registration still pending", HttpStatus.BAD_REQUEST);
				case "resubmitted":
					return new ResponseEntity<>("Registration resubmitted", HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Id does not exist", HttpStatus.BAD_REQUEST);
			}
    	}else {
			return new ResponseEntity<>("Only students can register for a class", HttpStatus.BAD_REQUEST);
    	}
		return null;
		
    	
		
	}
	
	//Delete a registration by id
	@DeleteMapping(value = "/delete/{id}")
	  public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
    	if(rs.deleteRegistration(id)) {
			return new ResponseEntity<>("Delete successful",HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
	
	//Get a registration by id
    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
    	Registration reg= rs.getByRegistrationId(id);
    	if(reg == null) {
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}
    }
	
    //List of all registrations by a student
	@GetMapping(value = "/AllStudentReg/{stu_id}")
	public ResponseEntity<?> studentRegistrations(@PathVariable("stu_id") int id){
		List<Registration> reg = rs.getAllByStudentId(id);
		if(reg == null){
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}
			
	}
	
	//List of all pending request for tutor
	@GetMapping(value = "/Allpending/{tutor_id}")
	public ResponseEntity<?> pendingRegistrations(@PathVariable("tutor_id") int id){
		List<Registration> reg = rs.getAllTutorPending(id);
		if(reg == null){
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(reg,HttpStatus.OK); 
		}	
	}
	
	//accepting a student to a class
	@PostMapping(value = "/accept/{reg_id}")
	public ResponseEntity<String> acceptRegistrations(@PathVariable("reg_id") int id){
		Registration reg = rs.accept(id);
		if(reg != null) {
			if(cs.enroll(reg.getClassId(), reg.getStudentId())){
				return new ResponseEntity<>("Course enrollment sucessful" ,HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Course enrollment unsucessful" ,HttpStatus.BAD_REQUEST); 
			}
				
		}else {
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}
	}
	
	//rejecting student to a class
	@PostMapping(value = "/reject/{reg_id}")
	public ResponseEntity<String> rejectRegistrations(@PathVariable("reg_id") int id){
		Registration reg = rs.reject(id);
		if(reg != null) {
			if(cs.reject(reg.getClassId(), reg.getStudentId())) {
				return new ResponseEntity<>("Course Rejection successful" ,HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Course Rejection unsuccessful" ,HttpStatus.BAD_REQUEST); 

			}
		}else {
			return new ResponseEntity<>("Id does not exist" ,HttpStatus.BAD_REQUEST); 
		}
	
	}   
}
