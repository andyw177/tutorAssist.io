package com.se785.TutorAssist.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(nullable = false)
	int studentId;
	@Column(nullable = false)
	String firstName;
	@Column(nullable = false)
	String lastName;
	@Column(nullable = false,unique = true)
	String username;
	@Column(nullable = false)
	String password;
	@Column(nullable = false)
	String email;
	@Column
	String birthdate;
	@Column
	String gender;
	@Column(nullable = false)
	String securityQues;
	@Column(nullable = false)
	String securityAns;
	@Column(nullable = false)
	boolean isAdmin;
	
	
	@ManyToMany(mappedBy = "students", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JsonIgnoreProperties({"students","tutor"})
//	@ManyToMany @Column
//	@JsonIgnoreProperties({"students"})
	
	Set<Course> courses;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String firstName, String lastName, String username, String password, String email,
			String birthdate, String gender, String securityQues, String securityAns, boolean isAdmin, Set<Course> courses) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthdate = birthdate;
		this.gender = gender;
		this.securityQues = securityQues;
		this.securityAns = securityAns;
		this.isAdmin = isAdmin;
		this.courses = courses;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
