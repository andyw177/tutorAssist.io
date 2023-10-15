package com.se785.TutorAssist.models;

import java.util.List;

public class Tutor extends User {
	List available_times;
	List classes;
	List students_list;

	
	public Tutor(int id, String name, String password, String email, UserType user_type, String security_ques,
			String security_ans, boolean isAdmin, int rating) {
		super(id, name, password, email, user_type, security_ques, security_ans, isAdmin, rating);
		// TODO Auto-generated constructor stub
	}

	

	public List getAvailable_times() {
		return available_times;
	}



	public void setAvailable_times(List available_times) {
		this.available_times = available_times;
	}



	public List getClasses() {
		return classes;
	}



	public void setClasses(List classes) {
		this.classes = classes;
	}



	public List getStudents_list() {
		return students_list;
	}



	public void setStudents_list(List students_list) {
		this.students_list = students_list;
	}



	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	 
}
