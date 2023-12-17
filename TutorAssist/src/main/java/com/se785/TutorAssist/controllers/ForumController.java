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

import com.se785.TutorAssist.models.Forum;
import com.se785.TutorAssist.services.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
	private ForumService fs;
	@Autowired
	public ForumController(ForumService fs) {
		super();
		this.fs = fs;
	}
	// Test Route
		@GetMapping("/test")
		public String test(){
			return "Hello World";
		}
		 //Creates a new Forum entry in the database using the given information.
	    @PostMapping(value="/create")
	    public HttpStatus createRequest(@RequestBody Forum forum) {
	    	fs.createForum(forum);
			return HttpStatus.OK;
	    }
	    
	    //Updates a forum entry in the database using the given information.
	    @PutMapping(value="/update")
	    public ResponseEntity<String> updateRequest(@RequestBody Forum forum){
			if(fs.updateForum(forum)) {
				return new ResponseEntity<>("Update successful" , HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Update unsuccessful", HttpStatus.BAD_REQUEST); 
			}
		}
	    
	    //Deletes a forum entry in the database using the given information.
	    @DeleteMapping(value="/delete/{id}")
	    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id) {
	    	if(fs.deleteForum(id)) {
				return new ResponseEntity<>("Delete successful" , HttpStatus.OK); 
			}else {
				return new ResponseEntity<>("Id does not exist" , HttpStatus.BAD_REQUEST); 
			}
	    }
	    
		//Provides a forum on the database that matches a given criteria and sends it back as JSON.
	    @GetMapping(value="/get/{id}")
	    public ResponseEntity<?> getRequest(@PathVariable("id") int id) {
	    	Forum forum = fs.getForumById(id);
	    	if(forum == null) {
				return new ResponseEntity<>("Id does not exist",  HttpStatus.BAD_REQUEST); 
			}else {
				return new ResponseEntity<>(forum,HttpStatus.OK); 
			}
	    }

}
