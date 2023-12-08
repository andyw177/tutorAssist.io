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
	public MessageController(MessageService ms) {
		super();
		this.ms = ms;
	}
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TutorService tutorService;
	
	// Test Route
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
	 //Creates a new User entry in the database using the given information.
    @PostMapping(value="/create")
    public ResponseEntity<?> createRequest(@RequestBody Message message) {
    	//gets the user from the context
    	User current_user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Collection<GrantedAuthority>roles = current_user.getAuthorities();
    	
    	if(roles.iterator().next().getAuthority()=="STUDENT")
    		message.setSenderId(studentService.getStudentByUsername(current_user.getUsername()).getStudentId());
    	else
    		message.setSenderId(tutorService.getTutorByUsername(current_user.getUsername()).getTutorId());
    	
    	if(message.getSenderId()==message.getReceiverId())
    		return ResponseEntity.badRequest().body("You can't send a message to yourself!");
    	
    	ms.createMessage(message);
    	
    	return ResponseEntity.ok(message);
    }
    
    //Updates a Users entry in the database using the given information.
    @PutMapping(value="/update")
    public ResponseEntity<String> updateRequest(@RequestBody Message message){
		if(ms.updateMessage(message)) {
			return new ResponseEntity<>(HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
    
    //Deletes a Users entry in the database using the given information.
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
    	if(ms.deleteMessage(id)) {
			return new ResponseEntity<>(HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
    }
    
	//Provides a Users on the database that matches a given criteria and sends it back as JSON.
    @GetMapping(value="/get/{id}")
    public ResponseEntity<Message> getRequest(@PathVariable("id") int id) {
    	Message message = ms.getByMessageId(id);
    	if(message == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(message,HttpStatus.OK); 
		}
    }
}
