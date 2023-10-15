package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	int id;
	String name;
	String password;
	String email;
	UserType user_type;
	String security_ques;
	String security_ans;
	boolean isAdmin;
	int rating;
	
	public User(int id, String name, String password, String email, UserType user_type, String security_ques,
			String security_ans, boolean isAdmin, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.user_type = user_type;
		this.security_ques = security_ques;
		this.security_ans = security_ans;
		this.isAdmin = isAdmin;
		this.rating = rating;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUser_type() {
		return user_type;
	}

	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}

	public String getSecurity_ques() {
		return security_ques;
	}

	public void setSecurity_ques(String security_ques) {
		this.security_ques = security_ques;
	}

	public String getSecurity_ans() {
		return security_ans;
	}

	public void setSecurity_ans(String security_ans) {
		this.security_ans = security_ans;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
	
}
