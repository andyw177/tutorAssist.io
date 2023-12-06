package com.se785.TutorAssist;

import java.util.Arrays;
import java.util.HashSet;
import java.sql.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.se785.TutorAssist.daos.CourseRepository;
import com.se785.TutorAssist.daos.StudentRepository;
import com.se785.TutorAssist.daos.TutorRepository;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;
import com.se785.TutorAssist.models.Course;

@Component
public class DBOperationRunner implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CourseRepository classRepo;

	@Autowired 
	TutorRepository tutorRepo;
	
	@Override
	public void run(String... args) throws Exception {	
		
		classRepo.deleteAllInBatch();
		studentRepo.deleteAllInBatch();
		tutorRepo.deleteAllInBatch();
		
		Student stu1 = new Student(1,"student","last","root","pass","test@gmail.com","1999","female","question1","answer1",true,null);
        Student stu2 =new Student(2,"student1","last1","student1","pass1","test1@gmail.com","1999","male","question1","answer1",false,null);
        Student stu3 =new Student(3,"student2","last2","student2","pass2","test2@gmail.com","1999","female","question1","answer1",false,null);
        Student stu4 =new Student(4,"student3","last3","student3","pass3","test3@gmail.com","1999","male","question1","answer1",false,null);
		Student[] stuArray = new Student[]{stu1,stu2,stu3,stu4};
	
	
		
		studentRepo.saveAll(Arrays.asList(stuArray));
		stu1.setStudentId(studentRepo.findByUsername(stu1.getUsername()).getStudentId());
		stu2.setStudentId(studentRepo.findByUsername(stu2.getUsername()).getStudentId());
		stu3.setStudentId(studentRepo.findByUsername(stu3.getUsername()).getStudentId());
		stu4.setStudentId(studentRepo.findByUsername(stu4.getUsername()).getStudentId());
		stuArray = new Student[]{stu1,stu2,stu3,stu4};
		
		Tutor tutor = new Tutor(1,"tutor","last","tutor","pass","test@gmail.com","PACE","MBA","CSE",new Date(900),"question","answer",false,0,null);
		Tutor tutor2 = new Tutor(2,"tutor2","last2","tutor2","pass2","test2@gmail.com","PACE","MBA","CSE",new Date(900),"question2","answer2",false,0,null);
		Tutor[] tutArray = new Tutor[] {tutor,tutor2};

		tutorRepo.saveAll(Arrays.asList(tutArray));
		tutor.setTutorId(tutorRepo.findByUsername(tutor.getUsername()).getTutorId());
		tutor2.setTutorId(tutorRepo.findByUsername(tutor2.getUsername()).getTutorId());
		
	
		Course[] classArray = new Course[]{
			new Course(1, "math",new HashSet<>(Arrays.asList(stuArray)),tutor,new Date(10),new Date(10)),
			new Course(2, "science",new HashSet<>(Arrays.asList(stuArray)),tutor,new Date(20),new Date(20)),
			new Course(3, "english",new HashSet<>(Arrays.asList(stuArray)), tutor2,new Date(20),new Date(20))
		}; 
	
		classRepo.saveAll(Arrays.asList(classArray));
		
		
	}
	
	
}
