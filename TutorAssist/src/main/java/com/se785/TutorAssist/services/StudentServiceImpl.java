package com.se785.TutorAssist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.se785.TutorAssist.daos.ClassRepository;

public class StudentServiceImpl implements StudentService {
	
	private ClassRepository cr;
	
	@Autowired
	public StudentServiceImpl(ClassRepository cr) {
		super();
		this.cr =cr;
	}

	@Override
	public List getClassList(int studentId) {
		// TODO Auto-generated method stub
//		cr.findByClassId(studentId);
//		cr.findAllByStudentId(studentId);
		return null;
	}

	@Override
	public List getTutorList(int tutorId) {
		// TODO Auto-generated method stub
//		cr.findAllByTutorId(tutorId);
		return null;
	}

}
