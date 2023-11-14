package com.se785.TutorAssist.services;

import com.se785.TutorAssist.models.Course;

public interface CourseService {
	public abstract Course createCourse(Course c);
	public abstract Course updateCourse(Course c);
	public abstract Course deleteCourse(int id);
	public abstract Course getCourseById(int id);
	
}
