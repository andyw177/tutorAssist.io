package com.se785.TutorAssist.jwt;

import com.se785.TutorAssist.services.TutorService;
import com.se785.TutorAssist.models.Student;
import com.se785.TutorAssist.models.Tutor;
import com.se785.TutorAssist.services.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//todo: could add encryption
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//Egemen Durmus
@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private TutorService tutorService;

	@Autowired
	private StudentService studentService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// ArrayList for authorities
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// look through students first
		Student res = studentService.getStudentByUsername(username);

		// if user can not be found in students, look through tutors
		if (res == null) {
			Tutor res_2 = tutorService.getTutorByUsername(username);
			if (res_2 == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			authorities.add(new SimpleGrantedAuthority("TUTOR"));
			return new User(res_2.getUsername(), res_2.getPassword(), authorities);
		} else {
			authorities.add(new SimpleGrantedAuthority("STUDENT"));
			return new User(res.getUsername(), res.getPassword(), authorities);
		}

	}

}