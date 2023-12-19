package com.se785.TutorAssist.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se785.TutorAssist.jwt.AuthenticationException;
import com.se785.TutorAssist.models.Message;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.services.MessageService;
import com.se785.TutorAssist.services.StudentService;
import com.se785.TutorAssist.services.TutorService;

@RestController
@RequestMapping("/messsage")
public class MessageController {
	private MessageService ms;
	@Autowired
	private TutorService tutorService;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	public MessageController(MessageService ms) {
		super();
		this.ms = ms;
	}
	
	// Test Route
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
	 //Creates a new User entry in the database using the given information.
    @PostMapping(value="/create")
    public ResponseEntity<?> createRequest(@RequestBody Message message) {
    	//getting the logged in user info
    	User current_user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	//setting sender id to the current user's id
    	if(current_user.getAuthorities().iterator().next().getAuthority()=="STUDENT")
    		message.setSenderId(studentService.getStudentByUsername(current_user.getUsername()).getStudentId());
    	else
    		message.setSenderId(tutorService.getTutorByUsername(current_user.getUsername()).getTutorId());
    	
    	if(message.getReceiverId()==message.getSenderId())
    		return ResponseEntity.badRequest().body("You can't send a message to yourself");
    	ms.createMessage(message);
    	return ResponseEntity.ok(current_user);
    }
    
    //Updates a Users entry in the database using the given information.
    @PostMapping(value="/update")
    public ResponseEntity<String> updateRequest(@RequestBody Message message){
		if(ms.updateMessage(message)) {
			return new ResponseEntity<>("Update successful",HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Update unsuccessful",HttpStatus.BAD_REQUEST); 
		}
	}
    
    //Deletes a Users entry in the database using the given information.
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
    	if(ms.deleteMessage(id)) {
			return new ResponseEntity<>("Delete successful" , HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
		}
    }
    
	//Provides a Users on the database that matches a given criteria and sends it back as JSON.
    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
    	Message message = ms.getByMessageId(id);
    	if(message == null) {
			return new ResponseEntity<>("Id does not exist",HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(message,HttpStatus.OK); 
		}
    }
    
    //returns the all messages associated with the current user
    @GetMapping(value="/allMessages")
    public ResponseEntity<?> getAllMessages() {
    	//getting the logged in user info
    	User current_user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	//setting sender id to the current user's id
    	if(current_user.getAuthorities().iterator().next().getAuthority()=="STUDENT")
    		return ResponseEntity.ok(ms.getAllMessages(studentService.getStudentByUsername(current_user.getUsername()).getStudentId()));
    	else
    		return ResponseEntity.ok(ms.getAllMessages(tutorService.getTutorByUsername(current_user.getUsername()).getTutorId()));
    }
}
