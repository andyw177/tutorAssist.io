package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByStudentId(int id);
	Student findByUsername(String username);
}
