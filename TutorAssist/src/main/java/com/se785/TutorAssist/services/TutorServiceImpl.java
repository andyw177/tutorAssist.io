package com.se785.TutorAssist.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.TutorRepository;
import com.se785.TutorAssist.models.Class;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;


@Service
public class TutorServiceImpl implements TutorService{
	
	private TutorRepository tr;
	
	public TutorServiceImpl(TutorRepository tr) {
		super();
		this.tr = tr;
	}

	@Override
	public Set<Class> getClassList(int tutorId) {
		Tutor t = tr.findByTutorId(tutorId);
		return t.getClasses();
	}

	@Override
	public Map<String, Set<Student>> getStudentList(int tutorId) {
		Tutor t = tr.findByTutorId(tutorId);
		Set<Class> classes = t.getClasses();
		Map<String,Set<Student>> students = new HashMap<String,Set<Student>>();
		for(Class c:classes) {
			students.put(c.getClassName(),c.getStudents());
		}
		return students;
	}

	@Override
	@Transactional
	public Tutor createTutor(Tutor tutor) {

		return tr.save(tutor);
	}

	@Override
	@Transactional
	public boolean deleteTutor(int id) {
		Tutor t = tr.findByTutorId(id);
		tr.delete(t);
		return true;
	}

	@Override
	@Transactional
	public boolean updateTutor(Tutor tutor) {
		tr.save(tutor);
		return true;
	}

	@Override
	public Tutor getTutorById(int id) {
		return tr.findByTutorId(id);
	}

	@Override
	public Set<Tutor> getAllTutors() {
		HashSet<Tutor> tutors =  new HashSet<Tutor>();
		tutors.addAll(tr.findAll());
		return tutors;
	}

}
