package com.se785.TutorAssist.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int studentId;
	String username;
	String password;
	String email;
	String securityQues;
	String securityAns;
	boolean isAdmin;
	int rating;
	
	
	@ManyToMany(mappedBy = "students", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JsonIgnoreProperties({"students"})
	Set<Class> classes = new HashSet<>();
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String username, String password, String email, 
			String securityQues, String securityAns, boolean isAdmin, int rating, Set<Class> classes) {
		super();
		this.studentId = studentId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.securityQues = securityQues;
		this.securityAns = securityAns;
		this.isAdmin = isAdmin;
		this.rating = rating;
		this.classes = classes;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
