package com.se785.TutorAssist.services;

import java.util.Map;
import java.util.Set;

import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;

public interface TutorService {
	public abstract Set<Course> getCourseList(int tutorId);
	public abstract Map<String, Set<Student>> getStudentList(int tutorId);
	public abstract Tutor createTutor(Tutor tutor);
	public abstract boolean deleteTutor(int id);
	public abstract boolean updateTutor(Tutor tutor);
	public abstract Tutor getTutorById(int id);
	public abstract Tutor getTutorByUsername(String username);
	public abstract Set<Tutor> getAllTutors();
}
