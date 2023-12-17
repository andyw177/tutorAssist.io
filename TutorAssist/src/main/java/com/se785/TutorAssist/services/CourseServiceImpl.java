package com.se785.TutorAssist.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.CourseRepository;
import com.se785.TutorAssist.daos.MessageRepository;
import com.se785.TutorAssist.daos.StudentRepository;
import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Message;
import com.se785.TutorAssist.models.Student;

@Service
public class CourseServiceImpl implements CourseService{
	private CourseRepository cr;
	private StudentRepository sr;
	private MessageRepository mr;
	
	@Autowired
	public CourseServiceImpl(CourseRepository cr,StudentRepository sr,MessageRepository mr) {
		super();
		this.cr = cr;
		this.sr = sr;
		this.mr = mr;
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
	public boolean reject(int classId, int studentId) {
		Course course = cr.findByCourseId(classId);
		Student stu = sr.findByStudentId(studentId);
		if(stu == null || course == null) {
			return false;
		}else {
			Message message = new Message();
			message.setReceiverId(stu.getStudentId());
			message.setSenderId(0);
			message.setContent("To: " + stu.getUsername()
			+  "\nFrom System: You have been rejected to take " +  course.getCourseName());
			mr.save(message);
			return true;
		}
	
	}
	@Override
	public boolean enroll(int classId, int studentId) {
		Course course = cr.findByCourseId(classId);
		Student s = sr.findByStudentId(studentId);
		
		
		if(s == null || course == null) {
			return false;
		}else {
			Set<Student> stu = course.getStudents();
			if(stu == null) {
				stu = new HashSet<Student>();
				stu.add(s);
			}else {
				stu.add(s);
			}
			course.setStudents(stu);
			cr.save(course);
			
			//make message for enrollment
			Message message = new Message();
			message.setReceiverId(s.getStudentId());
			message.setSenderId(0);
			message.setContent("To: " + s.getUsername()
			+  "\nFrom System: You have been accepted to take " +  course.getCourseName());
			mr.save(message);
			
			//schedule task to send message when class starts
			TimerTask CourseStartTask = new TimerTask() {
				public void run() {
					Message message = new Message();
					message.setReceiverId(s.getStudentId());
					message.setSenderId(0);
					message.setContent("To: " + s.getUsername() +  "\nFrom System: " + course.getCourseName() + " has started");
					mr.save(message);
				}
	
			};
			System.out.println(course.getStartDate());
			new Timer().schedule(CourseStartTask, course.getStartDate());
			
			return true;
			
		}
	}

}
