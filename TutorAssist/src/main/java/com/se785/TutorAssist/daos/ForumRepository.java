package com.se785.TutorAssist.daos;
import com.se785.TutorAssist.models.Forum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Andy Wang 
@Repository
public interface ForumRepository extends JpaRepository<Forum,Integer>{
	public abstract Forum findByForumId(int forumId);
	public abstract List<Forum> findAllByUserId(int userId); 
	
}
