package com.se785.TutorAssist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.CourseRepository;
import com.se785.TutorAssist.daos.StudentRepository;
import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Student;

@Service
public class CourseServiceImpl implements CourseService{
	private CourseRepository cr;
	private StudentRepository sr;
	
	@Autowired
	public CourseServiceImpl(CourseRepository cr,StudentRepository sr) {
		super();
		this.cr = cr;
		this.sr = sr;
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
	public Course getByCourseid(int id) {
		return cr.findByCourseId(id);
	}

	@Override
	public Set<Course> getAllCourses() {
		Set <Course> courses = new HashSet<Course>();
		courses.addAll(cr.findAll());
		return courses;
	}

	@Override
	public boolean enroll(int classId, int studentId) {
		Course course = cr.findByCourseId(classId);
		Student s = sr.findByStudentId(studentId);
		
		
		if(s == null || course == null) {
			return true;
		}else {
			Set<Student> stu = course.getStudents();
			if(stu == null) {
				stu = new HashSet<Student>();
				stu.add(s);
			}else {
				stu.add(s);
			}
			course.setStudents(stu);
			return true;
			
		}
	}

}
