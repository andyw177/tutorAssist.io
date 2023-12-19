package com.se785.TutorAssist.services;

import java.util.Set;

import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Student;

public interface CourseService {
	public abstract Course createCourse(Course c);
	public abstract boolean updateCourse(Course c);
	public abstract boolean deleteCourse(int id);
	public abstract Course getByCourseid(int id);
	public abstract Set<Course> getAllCourses();
	public abstract boolean enroll(int classId, int studentId);
	public abstract boolean reject(int classId, int studentId);
	public abstract String dropout(int classId, int studentId);

	
}
