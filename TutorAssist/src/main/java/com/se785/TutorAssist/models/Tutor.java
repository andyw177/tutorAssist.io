package com.se785.TutorAssist.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tutor {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	int tutorId;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column(nullable = false,unique = true)
	String username;
	@Column(nullable = false)
	String password;
	@Column
	String email;
	@Column
	String college;
	@Column
	String degreeType;
	@Column
	String major;
	@Column
	Date year;
	@Column
	String securityQues;
	@Column
	String securityAns;
	@Column
	boolean isAdmin;
	@Column
	int rating;
	@JsonIgnore
	@OneToMany(mappedBy = "tutor")
	Set<Course> courses;

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(int tutorId, String firstName, String lastName, String username, String password, String email,
			String college, String degreeType, String major, Date year, String securityQues, String securityAns,
			boolean isAdmin, int rating, Set<Course> courses) {
		super();
		this.tutorId = tutorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.college = college;
		this.degreeType = degreeType;
		this.major = major;
		this.year = year;
		this.securityQues = securityQues;
		this.securityAns = securityAns;
		this.isAdmin = isAdmin;
		this.rating = rating;
		this.courses = courses;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	
	 
}
