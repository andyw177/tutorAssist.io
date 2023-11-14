package com.se785.TutorAssist.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity

public class Course implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int courseId;
	String courseName;
//	@JsonIgnoreProperties({"courses"})
//	@ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//	@JoinTable(
//            name = "Studentcourses",
//            joinColumns = {@JoinColumn(name = "courseId")},
//            inverseJoinColumns = {@JoinColumn(name = "studentId")}
//    )
	@ManyToMany @Column
	@JsonIgnoreProperties({"courses"})
	Set<Student> students;
	@ManyToOne
	@JoinColumn(name="tutorId", nullable = false)
	@JsonIgnoreProperties({"courses"})
	Tutor tutor;
	Date startDate;
	Date endDate;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, Set<Student> students, Tutor tutor, Date startDate, Date endDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.students = students;
		this.tutor = tutor;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int CourseId) {
		this.courseId = CourseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String CourseName) {
		this.courseName = CourseName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
