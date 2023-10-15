package com.se785.TutorAssist.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Class {	
	@Id
	@GeneratedValue
	int classId;
	int tutorId;
	int studentId;
	Date startDate;
	Date endDate;
	public Class(int tutorId, int studentId, Date startDate, Date endDate) {
		super();
		this.tutorId = tutorId;
		this.studentId = studentId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
