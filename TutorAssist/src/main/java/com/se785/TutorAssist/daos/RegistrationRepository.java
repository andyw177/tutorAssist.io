package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer>{
	public abstract Registration findByRegistrationId(int id);
	public abstract List<Registration> findAllByStudentId(int id);
	public abstract List<Registration> findAllByTutorId(int id);
//	public abstract List<ClassRegistration> getAllByClassId(int id);
//	public abstract List<Registration> findAllTutorPending(int id);
	
	
}
