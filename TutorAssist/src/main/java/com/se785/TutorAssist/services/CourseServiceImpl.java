package com.se785.TutorAssist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.CourseRepository;
import com.se785.TutorAssist.models.Course;

@Service
public class CourseServiceImpl implements CourseService{
	private CourseRepository cr;
	
	@Autowired
	public CourseServiceImpl(CourseRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public Course createCourse(Course c) {
		return cr.save(c) ;
	}

	@Override
	public boolean updateCourse(Course c) {
		cr.save(c);
		return true;
	}

	@Override
	public boolean deleteCourse(int id) {
		Course course = cr.findByCourseId(id);
		if (course == null) {
			cr.delete(course);
			return true;
		}
		return false;
	}

	@Override
	public Course findByCourseid(int id) {
		return cr.findByCourseId(id);
	}

	@Override
	public Set<Course> findAllCourses() {
		Set <Course> courses = new HashSet<Course>();
		courses.addAll(cr.findAll());
		return courses;
	}

}
