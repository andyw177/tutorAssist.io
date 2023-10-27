package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.User;
import com.se785.TutorAssist.models.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
	User findByUsername(String username);
	List<User> findAll(); 
	List<User> findByUserType(UserType type);
}
