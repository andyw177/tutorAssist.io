package com.se785.TutorAssist.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.ClassRepository;
import com.se785.TutorAssist.daos.StudentRepository;
import com.se785.TutorAssist.daos.TutorRepository;
import com.se785.TutorAssist.models.Class;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;


@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository sr;
	
	@Autowired
	public StudentServiceImpl( StudentRepository sr) {
		super();
		this.sr = sr;
	}
	@Override
	@Transactional
	public Student createStudent(Student student) {
		return sr.save(student);
	}
	@Override
	@Transactional
	public boolean deleteStudent(int id) {
		Student st = sr.findByStudentId(id);
		sr.delete(st);
		return true;
	}
	@Override
	@Transactional
	public boolean updateStudent(Student student) {
		sr.save(student);
		return true;
	}
	@Override
	public Set<Class> getClassList(int studentId) {
		Student student = sr.findByStudentId(studentId);
		return student.getClasses();
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = sr.findByStudentId(studentId);
		return student;
	}
	@Override
	public Map<String, Tutor> getTutorList(int studentId) {
		Student student = sr.findByStudentId(studentId);
		Set<Class> classes = student.getClasses();
		Map<String, Tutor> tutorList = new HashMap<String, Tutor>();
		for(Class c:classes) {
			tutorList.put(c.getClassName(),c.getTutor());
			
		}
		return tutorList;
	}
	@Override
	public Set<Student> getAllStudents() {
		HashSet<Student> students =  new HashSet<Student>();
		students.addAll(sr.findAll());
		return students;
	}

}
