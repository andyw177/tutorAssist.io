package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassRegistration {
	@Id
	int registrationId;
	int tutorId;
	int studentId;
	RegistrationStatus status; 
	int classId;
	public ClassRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassRegistration(int registrationId, int tutorId, int studentId, RegistrationStatus status, int classId) {
		super();
		this.registrationId = registrationId;
		this.tutorId = tutorId;
		this.studentId = studentId;
		this.status = status;
		this.classId = classId;
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
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
	public RegistrationStatus getStatus() {
		return status;
	}
	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	
	
	
}
