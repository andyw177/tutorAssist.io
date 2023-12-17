package com.se785.TutorAssist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.RegistrationRepository;
import com.se785.TutorAssist.models.Registration;
import com.se785.TutorAssist.models.RegistrationStatus;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	private RegistrationRepository rr; 
	
	
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

}
