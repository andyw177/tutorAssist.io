package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByStudentId(int id);
	List<Student> findAll(); 
	Student findByUsername(String username);
}