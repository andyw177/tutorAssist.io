package com.se785.TutorAssist.services;

import java.util.Map;
import java.util.Set;

import com.se785.TutorAssist.models.Class;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;

public interface TutorService {
	public abstract Set<Class> getClassList(int tutorId);
	public abstract Map<String, Set<Student>> getStudentList(int tutorId);
	public abstract Tutor createTutor(Tutor tutor);
	public abstract boolean deleteTutor(int id);
	public abstract boolean updateTutor(Tutor tutor);
	public abstract Tutor getTutorById(int id);
	public abstract Set<Tutor> getAllTutors();
}
