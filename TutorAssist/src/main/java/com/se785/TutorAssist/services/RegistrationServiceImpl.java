package com.se785.TutorAssist.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.CourseRepository;
import com.se785.TutorAssist.daos.RegistrationRepository;
import com.se785.TutorAssist.daos.StudentRepository;
import com.se785.TutorAssist.models.Course;
import com.se785.TutorAssist.models.Registration;
import com.se785.TutorAssist.models.RegistrationStatus;
import com.se785.TutorAssist.models.Student;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	private RegistrationRepository rr; 
	
	@Autowired
	private StudentRepository sr;
	@Autowired
	private CourseRepository cr; 
	
	@Autowired
	public RegistrationServiceImpl(RegistrationRepository rr) {
		super();
		this.rr = rr;
	}

	@Override
	public Registration createRegistration(Registration reg) {
	
		return rr.save(reg);
	}

	@Override
	public boolean updateRegistration(Registration reg) {
		rr.save(reg);
		return true;
	}

	@Override
	public boolean deleteRegistration(int id) {
		Registration reg = rr.findByRegistrationId(id);
		if(reg!= null) {
			rr.delete(reg);
			return true;
		}
		return false;
	}

	@Override
	public Registration getByRegistrationId(int id) {
		return rr.findByRegistrationId(id);
	}

	@Override
	public List<Registration> getAllByStudentId(int id) {
		return rr.findAllByStudentId(id);
	}

	@Override
	public List<Registration> getAllTutorPending(int id) {
		List<Registration> ls = rr.findAllByTutorId(id);
		List<Registration> res = new ArrayList<>();
		for(Registration r:ls) {
			if(r.getStatus() == RegistrationStatus.pending) {
				res.add(r);
			}
		}
				
		return res;
		
		
	}

	@Override
	public Registration accept(int id) {
		Registration reg = rr.findByRegistrationId(id);
		reg.setStatus(RegistrationStatus.accepted);
		rr.save(reg);
		return reg;
	}

	@Override
	public Registration reject(int id) {
		Registration reg = rr.findByRegistrationId(id);
		reg.setStatus(RegistrationStatus.rejected);
		rr.save(reg);
		
		return reg;
	}

	@Override
	public String register(int classId, int studentId) throws Exception{
		Registration reg = new Registration();
		reg.setClassId(classId);
		reg.setStudentId(studentId);
		reg.setTutorId(cr.findByCourseId(classId).getTutor().getTutorId());
		reg.setStatus(RegistrationStatus.pending);
		
		Course course = cr.findByCourseId(classId);
		System.out.println(course.getStudents() + " " + course.getStartDate().compareTo(Date.valueOf(LocalDate.now())));
		if(course.getStartDate().compareTo(Date.valueOf(LocalDate.now())) < 0) {
			return "invalid";
		}
		for(Registration regS : rr.findAllByClassId(classId)) {
			if (regS.getStudentId() == studentId) {
				if(regS.getStatus().equals(RegistrationStatus.accepted)) {
					return "accepted";
				}else if(regS.getStatus().equals(RegistrationStatus.pending)) {
					return "pending";
				}else {
					regS.setStatus(RegistrationStatus.pending);
					rr.save(regS);
					return "resubmitted";
				}
				
			}
		}
		
		rr.save(reg);
		return "registered";
	}

}
