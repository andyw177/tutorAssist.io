package com.se785.TutorAssist.models;

import java.util.List;

public class Student extends User{
	List classes;
	List tutor_list;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String password, String email, UserType user_type, String security_ques,
			String security_ans, boolean isAdmin, int rating) {
		super(id, name, password, email, user_type, security_ques, security_ans, isAdmin, rating);
		// TODO Auto-generated constructor stub
	}
	public List getClasses() {
		return classes;
	}
	public void setClasses(List classes) {
		this.classes = classes;
	}
	public List getTutor_list() {
		return tutor_list;
	}
	public void setTutor_list(List tutor_list) {
		this.tutor_list = tutor_list;
	}
	
	
}
