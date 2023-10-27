package com.se785.TutorAssist.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity

public class Class implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int classId;
	@JsonIgnoreProperties({"classes"})
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JoinTable(
            name = "NewTable",
            joinColumns = {@JoinColumn(name = "classId")},
            inverseJoinColumns = {@JoinColumn(name = "studentId")}
    )
	Set<Student> students = new HashSet<Student>();
	@ManyToOne
	@JoinColumn(name="tutorId", nullable = false)
	Tutor tutor;
	Date startDate;
	Date endDate;
	public Class(int classId, Set<Student> students, Tutor tutor, Date startDate, Date endDate) {
		super();
		this.classId = classId;
		this.students = students;
//		this.tutor = tutor;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Set<Student> getStudent() {
		return students;
	}
	public void setStudent(Set<Student> student) {
		this.students = student;
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
