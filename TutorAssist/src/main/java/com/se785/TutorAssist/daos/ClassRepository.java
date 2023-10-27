package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer>{
//	Class findByClassId(int id);
//	Class findByTutorId(int id);
//	List<Class> findAll();
//	Class findByStudentId(int id);
//	List<Class> findAllByStudentId(int studentId);
//	List<Class> findAllByTutorId(int tutorId);
	
}
