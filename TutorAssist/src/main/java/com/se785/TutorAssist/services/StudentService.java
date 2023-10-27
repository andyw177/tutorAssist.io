package com.se785.TutorAssist.services;

import java.util.List;

public interface StudentService {
	public abstract List getClassList(int studentId);
	public abstract List getTutorList(int studentId);
	
	
}
