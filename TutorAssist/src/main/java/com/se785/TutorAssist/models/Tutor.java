package com.se785.TutorAssist.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Tutor {
	@Id
	@GeneratedValue
	int tutorId;
	String username;
	String password;
	String email;
	UserType userType;
	String securityQues;
	String securityAns;
	boolean isAdmin;
	int rating;
	
	@OneToMany(mappedBy = "tutor")
	Set<Class> classes;

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(int tutorId, String username, String password, String email, UserType userType, String securityQues,
			String securityAns, boolean isAdmin, int rating, Set<Class> classes) {
		super();
		this.tutorId = tutorId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.securityQues = securityQues;
		this.securityAns = securityAns;
		this.isAdmin = isAdmin;
		this.rating = rating;
		this.classes = classes;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getSecurityQues() {
		return securityQues;
	}

	public void setSecurityQues(String securityQues) {
		this.securityQues = securityQues;
	}

	public String getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
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

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	
	
	
	 
}
