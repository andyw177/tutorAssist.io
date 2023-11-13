package com.se785.TutorAssist.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.se785.TutorAssist.models.Class;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;

public interface StudentService {
	public abstract Set<Class> getClassList(int studentId);
	public abstract Map<String, Tutor> getTutorList(int studentId);
	public abstract Student createStudent(Student student);
	public abstract boolean deleteStudent(int id);
	public abstract boolean updateStudent(Student student);
	public abstract Student getStudentById(int studentId);
	public abstract Set<Student> getAllStudents();
	
	
}
