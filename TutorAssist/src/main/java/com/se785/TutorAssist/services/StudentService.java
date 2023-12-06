package com.se785.TutorAssist.services;

import java.util.Map;
import java.util.Set;

import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;

public interface StudentService {
	public abstract Set<Course> getCourseList(int studentId);
	public abstract Map<String, Tutor> getTutorList(int studentId);
	public abstract Student createStudent(Student student);
	public abstract boolean deleteStudent(int id);
	public abstract boolean updateStudent(Student student);
	public abstract Student getStudentById(int studentId);
	public abstract Set<Student> getAllStudents();
	public abstract Student getStudentByUsername(String username);
	
}
