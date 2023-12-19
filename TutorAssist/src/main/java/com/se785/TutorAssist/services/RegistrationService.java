package com.se785.TutorAssist.services;

import java.util.List;

import com.se785.TutorAssist.models.Registration;

public interface RegistrationService {
	public abstract Registration createRegistration(Registration reg);
	public abstract boolean updateRegistration(Registration reg);
	public abstract Registration deleteRegistration(int id);
	public abstract Registration getByRegistrationId(int id);
	public abstract List<Registration> getAllByStudentId(int id);
	public abstract List<Registration> getAllTutorPending(int id);
	public abstract Registration accept(int id);
	public abstract Registration reject(int id);
	public abstract String register(int classId, int studentId) throws Exception;
	
	
	
}
