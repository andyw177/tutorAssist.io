package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se785.TutorAssist.models.Tutor;
//Andy Wang 
public interface TutorRepository extends JpaRepository<Tutor,Integer>{
	Tutor findByTutorId(int id);
	List<Tutor> findAll();
	Tutor findByUsername(String username); 
}
