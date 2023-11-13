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

public class Class implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int classId;
	String className;
//	@JsonIgnoreProperties({"classes"})
//	@ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//	@JoinTable(
//            name = "StudentClasses",
//            joinColumns = {@JoinColumn(name = "classId")},
//            inverseJoinColumns = {@JoinColumn(name = "studentId")}
//    )
	@ManyToMany @Column
	@JsonIgnoreProperties({"classes"})
	Set<Student> students;
	@ManyToOne
	@JoinColumn(name="tutorId", nullable = false)
	@JsonIgnoreProperties({"classes"})
	Tutor tutor;
	Date startDate;
	Date endDate;
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class(int classId, String className, Set<Student> students, Tutor tutor, Date startDate, Date endDate) {
		super();
		this.classId = classId;
		this.className = className;
		this.students = students;
		this.tutor = tutor;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
