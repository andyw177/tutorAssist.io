package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Course;
//Andy Wang 
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findByCourseId(int id);

	
}
