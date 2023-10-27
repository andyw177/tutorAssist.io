package com.se785.TutorAssist.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se785.TutorAssist.models.Tutor;

public interface TutorRepository{ 
//	extends JpaRepository<Tutor,Integer>{

	Tutor getByTutorId(int id);
	

}
